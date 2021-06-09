package io.arha.ticketsvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.LoginDto;
import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketWrapperDto;
import io.arha.ticketsvc.dto.TokenDto;
import io.arha.ticketsvc.service.TicketService;
import io.arha.ticketsvc.service.TicketUserDetailsService;
import io.arha.ticketsvc.util.JwtUtil;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketUserDetailsService userDetailsService;

	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("")
	public String welcome() {
		return "welcome";
	}

	@PostMapping("/auth")
	public TokenDto login(@Valid @RequestBody LoginDto loginDto) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword()));
		
		UserDetails userDetail = userDetailsService.loadUserByUsername(loginDto.getUsername());
		return new TokenDto(jwtUtil.generateToken(userDetail));
	}

}
