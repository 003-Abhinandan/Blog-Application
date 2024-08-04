package com.codewithak.blog.payloads;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter

/**
 * we will use this class to work on User instead of User.
 * hm User.java m fields jyada/km kr sakte h but hm UserDto m wahi fields rakhenge jo input krna hoga real user kro. mtlb iska data hm
 * directly expose kr rhe honge apis. Directly hm entities ko expose nhi krenge, wo bs database k liye h.
 * 
 */
public class UserDto {
	
    private int id;
	private String name;
	private String email;
	private String password;
	private String about;
	
}
