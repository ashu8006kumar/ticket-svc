package io.arha.ticketsvc.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketWrapperDto;

@RestController
@RequestMapping("/home")
public class HomeController {
	@GetMapping("")
	public String welcome() {

		return "Hello@ from spring boot.";
	}

	@GetMapping("/{username}")
	public String welcome(@PathVariable("username") String name) {

		return "Hello! " + name;
	}

	@GetMapping("/my-tickets")
	public TicketWrapperDto myTickects() { 
		// Hard code/ fixed object 1
		TicketDto one = new TicketDto();
		one.setTicketSubject("Not able to view delete button.");
		one.setCreatedBy("ashu8006kumar@gmail.com");
		one.setDateCreated("26-May-2021");
		// Hard code object 2
		TicketDto two = new TicketDto();
		two.setTicketSubject("Not able to send money ushering your API");
		two.setCreatedBy("ashu8006kumar@gmail.com");
		two.setDateCreated("25-May-2021");
		

		List<TicketDto> data = new ArrayList<>();
		data.add(one);
		data.add(two);
		
		
		TicketWrapperDto ticketWrapperDto = new TicketWrapperDto();
		ticketWrapperDto.setData(data);
		return ticketWrapperDto;

	}

}
