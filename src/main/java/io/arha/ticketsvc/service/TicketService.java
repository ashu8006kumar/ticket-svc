package io.arha.ticketsvc.service;

import java.util.List;

import io.arha.ticketsvc.dto.TicketDto;

public interface TicketService {

	List<TicketDto> getMyTickets();

}
