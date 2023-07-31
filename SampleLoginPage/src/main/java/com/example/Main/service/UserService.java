package com.example.Main.service;

import java.util.List;

import com.example.Main.dto.UserDto;
import com.example.Main.entity.User;

public interface UserService {

	void saveUser(UserDto dto);
	
	User findByUserByEmail(String email);
	
	List<UserDto> findAllUsers();
	
}
