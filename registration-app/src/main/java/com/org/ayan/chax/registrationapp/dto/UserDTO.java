package com.org.ayan.chax.registrationapp.dto;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	
	private Long id;
	@NotEmpty
	private String firstname;
	@NotEmpty
	private String lastname;
	
	@NotEmpty(message = "Email should not be empty")
	@Email
	private String email;
	
	@NotNull(message = "Provide a valid DOB")
	private Date dob;

}
