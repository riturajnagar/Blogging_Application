package com.rituraj.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rituraj.blog.exceptions.ResourceNotFoundException;
import com.rituraj.blog.models.Category;
import com.rituraj.blog.payloads.CategoryDto;
import com.rituraj.blog.repositories.CategoryRepo;
import com.rituraj.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category createdCategory = this.categoryRepo.save(category);;
		return this.modelMapper.map(createdCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category ", "Id ", categoryId));
		
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		
		Category updatedCategory = this.categoryRepo.save(category);
		
		return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category ", "Id ", categoryId));
		
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getByIdCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
								.orElseThrow(()-> new ResourceNotFoundException("Category ", "Id ", categoryId));
		
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		
		List<CategoryDto> categoryDtos = this.categoryRepo.findAll()
											.stream()
											.map((category)->this.modelMapper.map(category, CategoryDto.class))
											.collect(Collectors.toList());
		
		return categoryDtos;
	}

}
