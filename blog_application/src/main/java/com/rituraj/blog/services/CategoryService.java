package com.rituraj.blog.services;

import java.util.List;

import com.rituraj.blog.payloads.CategoryDto;

public interface CategoryService {

//	create
	public CategoryDto createCategory(CategoryDto categoryDto);
	
//	update
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	
//	delete
	public void deleteCategory(Integer categoryId);
	
//	getByID
	public CategoryDto getByIdCategory(Integer categoryId);
	
//	getAll
	public List<CategoryDto> getAllCategory();
	
}
