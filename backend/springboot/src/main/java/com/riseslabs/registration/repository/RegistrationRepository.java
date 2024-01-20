package com.riseslabs.registration.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riseslabs.registration.model.RegistrationModel;

public interface RegistrationRepository extends JpaRepository<RegistrationModel, UUID>{

	public RegistrationModel findRegistrationEntityByPhone(String phone);

	public RegistrationModel findRegistrationEntityByEmail(String mail);

	public RegistrationModel findRegistrationEntityByUsername(String username);
	
	public RegistrationModel findRegistrationEntityByEmailOrPhoneOrUsername(
	        String email,
	        String phone,
	        String username
	    );
	

}
