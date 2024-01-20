package com.riseslabs.registration.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.riseslabs.registration.model.RegistrationModel;
import com.riseslabs.registration.repository.RegistrationRepository;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {
	
	
	private final RegistrationRepository registrationRepository;
	
	@Bean
	public UserDetailsService userDetailsService(){
				
		 return username -> {
			return  registrationRepository.findRegistrationEntityByEmailOrPhoneOrUsername(
						username,
						username,
						username
				    );		
		        } ;
		        
		       
		
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		
		authProvider.setPasswordEncoder(PasswordEncoder());
		return authProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}
	
	@Bean
	@Primary
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
