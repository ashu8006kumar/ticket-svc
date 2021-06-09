package io.arha.ticketsvc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketSubmitionDto;
import io.arha.ticketsvc.entity.Ticket;
import io.arha.ticketsvc.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;
	@Autowired
	private TicketUserDetailsService userDetailsService;

	@Override
	public List<TicketDto> getMyTickets() {
		
		// Hard code/ fixed object 1
		return ticketRepository.findAll().stream().map(ticket->{
			TicketDto dto = new TicketDto();
			dto.setTicketSubject(ticket.getTicketSubject());
			dto.setCreatedBy(ticket.getCreatedBy().getName());
			dto.setDateCreated(ticket.getCreatedDate().toString());
			return dto;
		}).collect(Collectors.toList());
	}

	@Override
	public TicketDto get(Long id) {
		Optional<Ticket> optional = ticketRepository.findById(id);
		if (optional.isPresent()) {
			Ticket ticket = optional.get();
			TicketDto dto = new TicketDto();
			dto.setTicketSubject(ticket.getTicketSubject());
			dto.setCreatedBy(ticket.getCreatedBy().getName());
			dto.setDateCreated("");
			return dto;
		} else {
			throw new RuntimeException("Record not found");
		}
	}

	@Override
	public void save(TicketSubmitionDto ticketSubmitionDto) {
		Ticket ticket= new Ticket();
		ticket.setTicketSubject(ticketSubmitionDto.getTicketSubject());
		ticket.setTicketDescription(ticketSubmitionDto.getDescription());
		ticket.setTicketType(ticketSubmitionDto.getType());
		ticket.setCreatedBy(userDetailsService.currentUser());
		ticketRepository.save(ticket);
	}

	@Override
	public void delete(Long id) {
		Optional<Ticket> optional = ticketRepository.findById(id);
		if (optional.isPresent()) {
			Ticket ticket = optional.get();
			ticketRepository.delete(ticket);
		} else {
			throw new RuntimeException("Record not found");
		}
	}

}
