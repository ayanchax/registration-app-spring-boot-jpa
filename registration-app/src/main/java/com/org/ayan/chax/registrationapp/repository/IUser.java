package com.org.ayan.chax.registrationapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.org.ayan.chax.registrationapp.entity.User;

public interface IUser extends JpaRepository<User,Long> {

	User findByEmail(String email);

	 
}
