package io.arha.ticketsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("")
	public String welcome() {
		return "welcome";
	}

	@PostMapping("/auth")
	public TokenDto login(@RequestBody LoginDto loginDto) {
		UserDetails userDetail = userDetailsService.loadUserByUsername(loginDto.getUsername());
		return new TokenDto(jwtUtil.generateToken(userDetail));
	}

	@GetMapping("/my-tickets")
	public TicketWrapperDto myTickects() {
		List<TicketDto> data = ticketService.getMyTickets();
		TicketWrapperDto ticketWrapperDto = new TicketWrapperDto();
		ticketWrapperDto.setData(data);
		return ticketWrapperDto;

	}

}
