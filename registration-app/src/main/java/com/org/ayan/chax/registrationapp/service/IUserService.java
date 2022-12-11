package com.org.ayan.chax.registrationapp.service;

import com.org.ayan.chax.registrationapp.dto.UserDTO;
import com.org.ayan.chax.registrationapp.entity.User;
import java.util.List;

import org.springframework.stereotype.Service;


public interface IUserService {

	void save(UserDTO userDto);
	
	User update(UserDTO userDTO);
	
	void delete(String email);

	User findUserByEmail(String email);

	List<UserDTO> findAllUsers();
	
}
