package com.example.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Main.entity.User;

public interface UserRespository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);
	
}
