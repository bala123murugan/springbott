package com.example.Main.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Main.dto.UserDto;
import com.example.Main.entity.Role;
import com.example.Main.entity.User;
import com.example.Main.repository.RoleRepository;
import com.example.Main.repository.UserRespository;

@Service
public class UserServiceImpl implements UserService {

	private UserRespository userRepo;
	private RoleRepository roleRepo;
	private PasswordEncoder passwordEncoder;

	public UserServiceImpl(UserRespository userRepository,
	                           RoleRepository roleRepository,
	                           PasswordEncoder passwordEncoder) {
		this.userRepo = userRepository;
	    this.roleRepo = roleRepository;
	    this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public void saveUser(UserDto userDto) {
		
		  User user = new User();
	        user.setUsername(userDto.getFirstName() + " " + userDto.getLastName());
	        user.setEmail(userDto.getEmail());
	        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

	        Role role = roleRepo.findByName("ROLE_ADMIN");
	        if(role == null){
	            role = checkRoleExist();
	        }
	        user.setRoles(Arrays.asList(role));
	        userRepo.save(user);
		
		
	}
	
	private Role checkRoleExist() {
		Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepo.save(role);
	}

	@Override
	public User findByUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	@Override
	public List<UserDto> findAllUsers() {
		
		List<User> userlist = userRepo.findAll();
		
		return userlist.stream().map((user)->mapToUserDto(user)).collect(Collectors.toList());
	}
	
	private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        String[] str = user.getUsername().split(" ");
        userDto.setFirstName(str[0]);
        userDto.setLastName(str[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }
	
	

}
