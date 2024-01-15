package com.riseslabs.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riseslabs.registration.entity.PasswordReset;
import com.riseslabs.registration.repository.PasswordResetRepository;

@Service
public class PasswordResetServiceImpl {
	
	@Autowired
	private PasswordResetRepository passwordResetRepository;
	
	public PasswordReset addMailToken(PasswordReset passwordReset) {
		
		return passwordResetRepository.save(passwordReset);
		
	}

}
