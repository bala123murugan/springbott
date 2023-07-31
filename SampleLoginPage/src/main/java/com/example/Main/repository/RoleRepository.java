package com.example.Main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Main.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(String name);
}
