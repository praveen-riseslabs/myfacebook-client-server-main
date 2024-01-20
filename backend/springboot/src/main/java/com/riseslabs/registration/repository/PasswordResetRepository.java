package com.riseslabs.registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.riseslabs.registration.model.PasswordResetModel;

public interface PasswordResetRepository extends JpaRepository<PasswordResetModel, Long>{
	
	public PasswordResetModel findPasswordResetByMail(String mail);
	
}
