package com.riseslabs.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.riseslabs.registration.model.PasswordResetModel;
import com.riseslabs.registration.repository.PasswordResetRepository;

@Service
public class PasswordResetServiceImpl {
	
	@Autowired
	private PasswordResetRepository passwordResetRepository;
	
	public PasswordResetModel addMailToken(PasswordResetModel passwordResetModel) {
		
		return passwordResetRepository.save(passwordResetModel);
		
	}

}
