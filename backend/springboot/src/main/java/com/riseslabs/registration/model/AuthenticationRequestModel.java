package com.riseslabs.registration.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequestModel {
	
	private String email;
	
	private String phone;
	
	private String username;
	
	String password;

}
