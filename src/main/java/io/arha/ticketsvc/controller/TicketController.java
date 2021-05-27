package io.arha.ticketsvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketSubmitionDto;
import io.arha.ticketsvc.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	public List<TicketDto> list() {
		return null;

	}

	@PostMapping("")
	public void save(@Valid @RequestBody TicketSubmitionDto ticketSubmitionDto) {

		System.out.println(ticketSubmitionDto.toString());

	}

}
