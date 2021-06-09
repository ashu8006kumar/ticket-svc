package io.arha.ticketsvc.service;

import java.util.List;

import io.arha.ticketsvc.dto.TicketDto;
import io.arha.ticketsvc.dto.TicketSubmitionDto;

public interface TicketService {

	List<TicketDto> getMyTickets();

	TicketDto get(Long id);

	void save(TicketSubmitionDto ticketSubmitionDto);

	void delete(Long id);
}
