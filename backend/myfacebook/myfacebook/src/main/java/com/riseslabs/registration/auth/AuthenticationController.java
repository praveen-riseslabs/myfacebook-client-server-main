package com.riseslabs.registration.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class AuthenticationController {
	
	@Autowired
	private final AuthenticationService authenticationService;


	@PostMapping("/saveUser")
	public ResponseEntity<String> register(@RequestBody RegisterRequest request){
	
		return authenticationService.register(request);
		
	}
	
	@PostMapping("/checkUser")
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
	public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.authenticate(request));
		
	}
	
	@PostMapping("/authenticateToken")
	public ResponseEntity<AuthenticationResponse> authenticateUserExist(@RequestBody AuthenticationRequest request){
		return ResponseEntity.ok(authenticationService.userExist(request));
	}
	
	@PostMapping("/saveEmailToken")
	public ResponseEntity<String> saveEmailToken(@RequestBody MailTokenRequest request){
		return authenticationService.saveToken(request);
	}
}