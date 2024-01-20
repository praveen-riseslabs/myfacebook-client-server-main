package com.riseslabs.registration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.riseslabs.registration.model.PasswordConfirmationModel;
import com.riseslabs.registration.model.RegistrationModel;
import com.riseslabs.registration.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RegistrationRepository registrationRepository;

	public RegistrationModel adduser(RegistrationModel registrationModel) {

		return registrationRepository.save(registrationModel);

	}

	public boolean findByPhone(String phone) {
		RegistrationModel ex = registrationRepository.findRegistrationEntityByPhone(phone);
		if (ex != null)
			return true;
		else
			return false;
	}

	public boolean findByEmail(String mail) {
		RegistrationModel ex = registrationRepository.findRegistrationEntityByEmail(mail);
		if (ex != null)
			return true;
		else
			return false;
	}

	public boolean findByUsername(String username) {
		RegistrationModel ex = registrationRepository.findRegistrationEntityByUsername(username);
		if (ex != null)
			return true;
		else
			return false;
	}

	public boolean getUser(String username) {

		RegistrationModel user = registrationRepository.findRegistrationEntityByEmailOrPhoneOrUsername(username,
				username, username);

		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	public RegistrationModel findUser(String username) {

		RegistrationModel user = registrationRepository.findRegistrationEntityByEmailOrPhoneOrUsername(username,
				username, username);

		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public ResponseEntity<String> resetPassword(PasswordConfirmationModel request) {

		RegistrationModel user = registrationRepository.findRegistrationEntityByEmail(request.getEmail());

		String password = passwordEncoder.encode(request.getConfirmPassword());

		user.setPassword(password);

		RegistrationModel passwordResetEntity = registrationRepository.save(user);

		if (passwordResetEntity != null)
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": false}");

	}

}
