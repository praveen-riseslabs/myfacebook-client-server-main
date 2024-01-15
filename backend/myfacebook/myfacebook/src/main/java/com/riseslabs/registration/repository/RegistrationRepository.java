package com.riseslabs.registration.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riseslabs.registration.entity.RegistrationEntity;

public interface RegistrationRepository extends JpaRepository<RegistrationEntity, UUID>{

	public RegistrationEntity findRegistrationEntityByPhone(String phone);

	public RegistrationEntity findRegistrationEntityByEmail(String mail);

	public RegistrationEntity findRegistrationEntityByUsername(String username);
	
	public RegistrationEntity findRegistrationEntityByEmailOrPhoneOrUsername(
	        String email,
	        String phone,
	        String username
	    );
	

}
