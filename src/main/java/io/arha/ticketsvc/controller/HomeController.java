package io.arha.ticketsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketWrapperDto;
import io.arha.ticketsvc.props.EmailProps;
import io.arha.ticketsvc.service.TicketService;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private TicketService ticketService;
 
	@Autowired
	private EmailProps emailProps;

	@GetMapping("")
	public String welcome() {  
		return emailProps.getHost();
				
	}

	@GetMapping("/{username}")
	public String welcome(@PathVariable("username") String name) {

		return "Hello! " + name;
	}

	@GetMapping("/my-tickets")
	public TicketWrapperDto myTickects() {
		List<TicketDto> data = ticketService.getMyTickets();
		TicketWrapperDto ticketWrapperDto = new TicketWrapperDto();
		ticketWrapperDto.setData(data);
		return ticketWrapperDto;

	}

}
