package com.riseslabs.registration.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.riseslabs.registration.configuration.JwtService;
import com.riseslabs.registration.service.EmailSenderService;
import com.riseslabs.registration.model.AuthenticationRequestModel;
import com.riseslabs.registration.model.AuthenticationResponseModel;
import com.riseslabs.registration.model.MailTokenRequestModel;
import com.riseslabs.registration.model.PasswordResetModel;
import com.riseslabs.registration.model.RegisterRequestModel;
import com.riseslabs.registration.model.RegistrationModel;
import com.riseslabs.registration.model.Role;
import com.riseslabs.registration.repository.PasswordResetRepository;
import com.riseslabs.registration.repository.RegistrationRepository;
import com.riseslabs.registration.service.PasswordResetServiceImpl;
import com.riseslabs.registration.service.RegistrationServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	@Autowired
	private final EmailSenderService emailSenderService;
	
	@Autowired
	private final PasswordResetRepository passwordResetRepository;
	
	@Autowired
	private final PasswordResetServiceImpl passwordResetServiceImpl;

	@Autowired
	private final RegistrationRepository registrationRepository;

	@Autowired
	private final RegistrationServiceImpl registrationServiceImpl;

	@Qualifier("passwordEncoder")
	private final PasswordEncoder passwordEncoder;

	@Autowired
	private final JwtService jwtService;

	@Autowired
	private final AuthenticationManager authenticationManager;

	public ResponseEntity<String> register(RegisterRequestModel request) {

		var user = RegistrationModel.builder().name(request.getName()).username(request.getUsername())
				.email(request.getEmail()).gender(request.getGender()).phone(request.getPhone())
				.createdAt(request.getCreatedAt()).password(passwordEncoder.encode(request.getPassword()))
				.role(Role.USER).build();

		RegistrationModel regEntity = registrationServiceImpl.adduser(user);

		if (regEntity != null)
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"status\": false}");

	}

	public AuthenticationResponseModel authenticate(AuthenticationRequestModel request) {

		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		var user = registrationRepository.findRegistrationEntityByEmailOrPhoneOrUsername(request.getUsername(),
				request.getUsername(), request.getUsername());

		var jwtToken = jwtService.generateToken(user);
		
		String uuid = user.getId().toString();
		
		String name = user.getName();

		return AuthenticationResponseModel.builder().token(jwtToken).userid(uuid).userName(name).build();
	}

	public List<String> checkExistingFields(String email, String phone, String username) {
		List<String> existingFields = new ArrayList<>();

		if (registrationRepository.findRegistrationEntityByEmail(email) != null) {
			existingFields.add("email");
		}
		if (registrationRepository.findRegistrationEntityByPhone(phone) != null) {
			existingFields.add("phone");
		}
		if (registrationRepository.findRegistrationEntityByUsername(username) != null) {
			existingFields.add("username");
		}

		return existingFields;
	}

	public AuthenticationResponseModel userExist(AuthenticationRequestModel request) {

		var user = registrationRepository.findRegistrationEntityByEmail(request.getEmail());
		
		var jwtToken = jwtService.generateToken(user);

		return AuthenticationResponseModel.builder().token(jwtToken).build();
	}

	public ResponseEntity<String> saveToken(MailTokenRequestModel request) {
		
		PasswordResetModel example = passwordResetRepository.findPasswordResetByMail(request.getEmail());
		String token;
		if(example != null) {
			example.setToken(request.getToken());
			example = passwordResetServiceImpl.addMailToken(example);
			token = example.getToken();
			emailSenderService.sendEmail(example.getMail(), "Reset password link", "http://localhost:8080/resetPassword?token="+token+"&email="+example.getMail());
			
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");
		}
			
				
		var user = PasswordResetModel.builder().mail(request.getEmail()).token(request.getToken()).build();
		
		PasswordResetModel tokenEntity =  passwordResetServiceImpl.addMailToken(user);
		
		token = tokenEntity.getToken();
		
		emailSenderService.sendEmail(tokenEntity.getMail(),
				"Reset password link", "http://localhost:8080/resetPassword?token="+token+"&email="+tokenEntity.getMail());
		

			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": true}");

		
	}

}
