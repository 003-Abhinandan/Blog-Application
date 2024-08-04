package com.codewithak.blog.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codewithak.blog.entities.User;
import com.codewithak.blog.payloads.UserDto;
import com.codewithak.blog.repositories.UserRepo;
import com.codewithak.blog.services.UserService;
import com.codewithak.blog.exceptions.*;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;  //exactly kaise kaam krta h? I don't know as of now....

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = dtoToUser(userDto);
		User savedUser = (User) userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId){
		//User user=(User) this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","Id",userId));
		User user=(User) this.userRepo.findById(userId).orElseThrow();
		user.setAbout(userDto.getAbout());
		user.setEmail(userDto.getName());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		User updatedUser = (User) this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUser);
		return userDto1;
	}

	
	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		Object user = this.userRepo.findById(userId).orElseThrow();
		UserDto userDto = userToDto((User)user);
		return userDto;
	}

	@Override
	public List<UserDto> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> users = this.userRepo.findAll();
		List<UserDto> userDtos = users.stream().map(user -> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		User user = (User)this.userRepo.findById(userId).orElseThrow();
		this.userRepo.delete(user);
		
	}
	
	public User dtoToUser(UserDto userDto) {
		User user = new User();
		//user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		return user;
		
	}
	
	public UserDto userToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setPassword(user.getPassword());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		
		return userDto;
	}

	/*
	 * any other methods/functionalities you want to add, declare in the UserService interface and provide the implementations here.
	 * */
	
}
