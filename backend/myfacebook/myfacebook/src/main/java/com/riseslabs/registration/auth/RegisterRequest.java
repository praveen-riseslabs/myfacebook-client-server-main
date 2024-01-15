package com.riseslabs.registration.auth;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

	private String name;
	private String username;
	private String email;
	private String phone;
	private String password;
	private String gender;
	private final String createdAt = LocalDateTime.now()
			.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
	
}
