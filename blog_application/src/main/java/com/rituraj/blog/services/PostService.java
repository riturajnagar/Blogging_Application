package com.rituraj.blog.services;

import java.util.List;

import com.rituraj.blog.models.Post;
import com.rituraj.blog.payloads.CategoryDto;
import com.rituraj.blog.payloads.PostDto;
import com.rituraj.blog.payloads.UserDto;

public interface PostService {

//	create
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
//	update
	PostDto updatePost(PostDto postDto, Integer postId);
	
//	delete
	void deletePost(Integer postId);
	
//	getAllPost 
	List<PostDto> getAllPosts();
	
//	getPostById 
	Post getPostById(Integer postId);
	
//	getByUser
	List<PostDto> getPostsByUser(UserDto userDto);
	
//	getByCategory
	List<PostDto> getPostsByCategory(CategoryDto categoryDto);
	
//	search post 
	List<Post> searchPosts(String keyword);
	
}
