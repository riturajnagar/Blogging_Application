package com.rituraj.blog.payloads;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Validated
public class UserDto {

	private Integer id;
	
	@NotEmpty
	@Size(min = 4, message = "Name must have min 4 characters")
	private String name;
	
	@Email(message = "Email address is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be between 3 to 10 chars")
	private String password;
	
	@NotEmpty
	private String about;
}
