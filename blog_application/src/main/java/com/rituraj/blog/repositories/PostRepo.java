package com.rituraj.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rituraj.blog.models.Post;
import com.rituraj.blog.payloads.CategoryDto;
import com.rituraj.blog.payloads.UserDto;

public interface PostRepo extends JpaRepository<Post, Integer> {
	
	List<Post> findByUser(UserDto userDto);
	
	List<Post> findByCategory(CategoryDto categoryDto);

}
