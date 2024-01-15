package com.riseslabs.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.riseslabs.registration.auth.MailTokenRequest;
import com.riseslabs.registration.entity.RegistrationEntity;
import com.riseslabs.registration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RegistrationRepository registrationRepository;

	public RegistrationEntity adduser(RegistrationEntity registrationEntity) {

		return registrationRepository.save(registrationEntity);

	}

	public boolean findByPhone(String phone) {
		RegistrationEntity ex = registrationRepository.findRegistrationEntityByPhone(phone);
		if (ex != null)
			return true;
		else
			return false;
	}

	public boolean findByEmail(String mail) {
		RegistrationEntity ex = registrationRepository.findRegistrationEntityByEmail(mail);
		if (ex != null)
			return true;
		else
			return false;
	}

	public boolean findByUsername(String username) {
		RegistrationEntity ex = registrationRepository.findRegistrationEntityByUsername(username);
		if (ex != null)
			return true;
		else
			return false;
	}

	public boolean getUser(String username) {

		RegistrationEntity user = registrationRepository.findRegistrationEntityByEmailOrPhoneOrUsername(username,
				username, username);

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public RegistrationEntity findUser(String username) {

		RegistrationEntity user = registrationRepository.findRegistrationEntityByEmailOrPhoneOrUsername(username,
				username, username);

		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public ResponseEntity<String> resetPassword(MailTokenRequest request) {

		RegistrationEntity user = registrationRepository.findRegistrationEntityByEmail(request.getEmail());

		String password = passwordEncoder.encode(request.getToken());

		user.setPassword(password);

		RegistrationEntity passwordResetEntity = registrationRepository.save(user);

		if (passwordResetEntity != null)
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": false}");

	}

}
