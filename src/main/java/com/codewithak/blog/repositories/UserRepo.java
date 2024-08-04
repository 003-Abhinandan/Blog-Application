package com.codewithak.blog.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithak.blog.entities.User;

public interface UserRepo<D> extends JpaRepository<User, Integer>{
      
	
}
