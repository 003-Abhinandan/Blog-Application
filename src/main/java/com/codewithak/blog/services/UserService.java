package com.codewithak.blog.services;

import java.util.List;

import com.codewithak.blog.payloads.UserDto;

/**
 * Ctrl+shift+o -> to import
 */
public interface UserService {
          
	   UserDto createUser(UserDto user);
	   UserDto updateUser(UserDto user,Integer userId);
	   UserDto getUserById(Integer userId);
	   List<UserDto>getAllUsers();
	   void deleteUser(Integer userId);
	   
}
