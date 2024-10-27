package com.rituraj.blog.services.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rituraj.blog.exceptions.ResourceNotFoundException;
import com.rituraj.blog.models.Category;
import com.rituraj.blog.models.Post;
import com.rituraj.blog.models.User;
import com.rituraj.blog.payloads.CategoryDto;
import com.rituraj.blog.payloads.PostDto;
import com.rituraj.blog.payloads.UserDto;
import com.rituraj.blog.repositories.CategoryRepo;
import com.rituraj.blog.repositories.PostRepo;
import com.rituraj.blog.repositories.UserRepo;
import com.rituraj.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
		In this method we need to find the user and category and mannualy assign to a post
		because we need to save the post with the details like who created post and 
		which category belongs to
	**/
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user = this.userRepo.findById(userId)
				.orElseThrow(()-> new ResourceNotFoundException("User ", "Id ", userId));
		
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(()-> new ResourceNotFoundException("Category ", "Id ", categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setCategory(category);
		post.setUser(user);
		post.setAddedDate(new Date());
		
		Post createdPost = this.postRepo.save(post);
		
		PostDto createdPostDto = this.modelMapper.map(createdPost, PostDto.class);
		
		return createdPostDto;
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer postId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PostDto> getAllPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(Integer postId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Post> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
