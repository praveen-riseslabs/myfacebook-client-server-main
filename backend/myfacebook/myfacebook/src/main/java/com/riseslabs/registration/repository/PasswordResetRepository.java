package com.riseslabs.registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.riseslabs.registration.entity.PasswordReset;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Long>{
	
	public PasswordReset findPasswordResetByMail(String mail);
	
}
