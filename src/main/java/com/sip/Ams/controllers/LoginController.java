package com.sip.Ams.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sip.Ams.configuration.JwtUtil;
import com.sip.Ams.entities.User;
import com.sip.Ams.models.AuthenticationResponse;
import com.sip.Ams.service.MyUserDetailsService;



@RestController
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	 @RequestMapping(value ="/login", method = RequestMethod.POST)
 
	public ResponseEntity<?> createAuthentificationToken(@RequestBody User user) throws Exception {
	
	try {
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		
	}catch (BadCredentialsException e) {
		throw new Exception("Incorrect username or password", e);
	}
	
	final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
	final String token = jwtTokenUtil.generateToken(userDetails);
	System.out.println("TOKEN USER"+token);
 
	return ResponseEntity.ok(new AuthenticationResponse(token, user.getUsername(), userDetails.getAuthorities()));
	}
}
