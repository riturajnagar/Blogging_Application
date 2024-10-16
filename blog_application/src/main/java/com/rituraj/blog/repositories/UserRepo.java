package com.rituraj.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rituraj.blog.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
