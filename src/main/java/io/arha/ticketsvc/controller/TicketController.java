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
import io.arha.ticketsvc.entity.Ticket;
import io.arha.ticketsvc.repository.TicketRepository;
import io.arha.ticketsvc.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	private TicketService ticketService;
	@Autowired
	private TicketRepository ticketRepository;

	public List<TicketDto> list() {
		return null;

	}

	@PostMapping("")
	public void save(@Valid @RequestBody TicketSubmitionDto ticketSubmitionDto) {
		
		List<Ticket> list = ticketRepository.findAllByTicketSubject(ticketSubmitionDto.getTicketSubject());
		for (Ticket t : list) {
			System.out.println(t.getId());
			System.out.println(t.getTicketSubject());
		}
	}

}
