package com.rituraj.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rituraj.blog.payloads.ApiResponse;
import com.rituraj.blog.payloads.UserDto;
import com.rituraj.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blog/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	//Create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
		UserDto createdUserDto = this.userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(createdUserDto, HttpStatus.CREATED);
	}
	
	//Update User (Path variable name should be same as in URI)
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable Integer userId){
		UserDto updatedUserDto = this.userService.updateUser(userDto, userId);
		
//		we can also write this return statement
//		return ResponseEntity.ok(updatedUserDto);
		
		return new ResponseEntity<UserDto>(updatedUserDto, HttpStatus.OK);
		
	}
	
	//Delete User
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		
//		return ResponseEntity.ok(Map.of("message", "User Deleted Successfully"));
		
		return new ResponseEntity<>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
	
	//Get User by ID
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
		UserDto userDtoFound = this.userService.getUserById(userId);
		
		return ResponseEntity.ok(userDtoFound);
	}
	
	//Get all Users
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		List<UserDto> usersDto = this.userService.getAllUsers();
		
		return ResponseEntity.ok(usersDto);
	}
}
