package com.codewithak.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codewithak.blog.payloads.UserDto;
import com.codewithak.blog.services.UserService;



@RestController
@RequestMapping("/api/users")
public class UserController{
    	/*
    	 * POST - create user
    	 * PUT - update user
    	 * DELETE - delete user
    	 * GET - get user
    	 */
	
	/*
	 * UserDto , we have created because we donot want to expose the entity, let's say we donot want to expose the password but 
	 * but User will have it so we what will do is we will not include in the UserDto.
	 */
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto>createUser(@RequestBody UserDto userDto){
		 UserDto createUserDto = this.userService.createUser(userDto);
		 return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
		
	}	
	
	@PutMapping("/{userId}")
	public ResponseEntity<?>updateUser(@RequestBody UserDto userDto, @PathVariable("userId") Integer uid){ //agar type nahi pta to place ? instead of actaul className.
		UserDto updatedUser = this.userService.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer uid){
		this.userService.deleteUser(uid);
		return new ResponseEntity(Map.of("message","User Deleted Successfully"), HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>>getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto>getSingleUser(@PathVariable("userId") Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	
}
