package com.org.ayan.chax.registrationapp.service.impl;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.ayan.chax.registrationapp.dto.UserDTO;
import com.org.ayan.chax.registrationapp.entity.User;
import com.org.ayan.chax.registrationapp.repository.IUser;
import com.org.ayan.chax.registrationapp.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IUser userRepository;
	 

	@Override
	public void save(UserDTO userDto) {
		  User user = new User();
	        user.setFirstname(userDto.getFirstname());
	        user.setLastname(userDto.getLastname());
	        user.setEmail(userDto.getEmail());
	        user.setDob(userDto.getDob());
	         
	        userRepository.save(user);
		
	}

	@Override
	public User update(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<UserDTO> findAllUsers() {
		 List<User> users = userRepository.findAll();
	        return users.stream().map((user) -> convertRepoEntityToDto(user))
	                .collect(Collectors.toList());
	}
	
	
	 private UserDTO convertRepoEntityToDto(User user){
		 UserDTO userDto = new UserDTO();
	        userDto.setFirstname(user.getFirstname());
	        userDto.setLastname(user.getLastname());
	        userDto.setEmail(user.getEmail());
	        return userDto;
	    }

}
