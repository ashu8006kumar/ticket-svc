package io.arha.ticketsvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketSubmitionDto;
import io.arha.ticketsvc.dto.TicketWrapperDto;
import io.arha.ticketsvc.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController { // C-R-U-D
	@Autowired
	private TicketService ticketService;

	
	@GetMapping("") 
	public TicketWrapperDto getTicketCreatedByUserList() {
		List<TicketDto> data = ticketService.getMyTickets();
		TicketWrapperDto ticketWrapperDto = new TicketWrapperDto();
		ticketWrapperDto.setData(data);
		return ticketWrapperDto;
	}
	
	@PostMapping("")
	public void save(@Valid @RequestBody TicketSubmitionDto ticketSubmitionDto) {
		ticketService.save(ticketSubmitionDto);
	}

	@GetMapping("/{id}")
	public TicketSubmitionDto read(@PathVariable Long id) {
		return ticketService.get(id);
	} 

	@PutMapping("/{id}")
	public void update(@PathVariable Long id, @Valid @RequestBody TicketSubmitionDto ticketSubmitionDto) {
		 ticketService.update(id, ticketSubmitionDto);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		 ticketService.delete(id);
	}

}
