package com.riseslabs.registration.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.riseslabs.registration.auth.AuthenticationService;
import com.riseslabs.registration.model.AuthenticationRequestModel;
import com.riseslabs.registration.model.AuthenticationResponseModel;
import com.riseslabs.registration.model.MailTokenRequestModel;
import com.riseslabs.registration.model.RegisterRequestModel;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/public")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private final AuthenticationService authenticationService;


	@PostMapping("/createuser")
	public ResponseEntity<String> register(@RequestBody RegisterRequestModel request){
	
		return authenticationService.register(request);
		
	}
	
	@PostMapping("/checkuser")
	public ResponseEntity<Map<String, Object>> checkUserExists(@RequestBody Map<String, String> userDetails) {
        String email = userDetails.get("email");
        String phone = userDetails.get("phone");
        String username = userDetails.get("username");
        
        List<String> existingFields = authenticationService.checkExistingFields(email, phone, username);
        Map<String, Object> response = new HashMap<>();
        if (!existingFields.isEmpty()) {
            response.put("exists", true);
            response.put("existingFields", existingFields);
        } else {
            response.put("exists", false);
        }
        
        return ResponseEntity.ok(response);
    }
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponseModel> register(@RequestBody AuthenticationRequestModel request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
		
	}
	
	@PostMapping("/authenticatetoken")
	public ResponseEntity<AuthenticationResponseModel> authenticateUserExist(@RequestBody AuthenticationRequestModel request){
		return ResponseEntity.ok(authenticationService.userExist(request));
	}
	
	@PostMapping("/savemailtoken")
	public ResponseEntity<String> saveEmailToken(@RequestBody MailTokenRequestModel request){
		return authenticationService.saveToken(request);
	}
}