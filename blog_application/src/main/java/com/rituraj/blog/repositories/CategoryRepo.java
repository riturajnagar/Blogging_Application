package com.rituraj.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rituraj.blog.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
