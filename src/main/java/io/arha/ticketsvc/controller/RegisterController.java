package io.arha.ticketsvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.RegisterDto;
import io.arha.ticketsvc.service.RegisterServcie;

@RestController
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private RegisterServcie registerServcie;

	@PostMapping("")
	public void registerNewUser(@Valid @RequestBody RegisterDto register) {
		registerServcie.registerNewUser(register);
		
	}
	
	@GetMapping("/verify/{registerLinkId}")
	public void verify(@PathVariable String registerLinkId) {
		registerServcie.findAndVerifyUserByLinkId(registerLinkId);
		
	}
}
