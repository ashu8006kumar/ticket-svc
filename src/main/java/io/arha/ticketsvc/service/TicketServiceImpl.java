package io.arha.ticketsvc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import io.arha.ticketsvc.dto.TicketDto;

@Service
public class TicketServiceImpl implements TicketService {

	@Override
	public List<TicketDto> getMyTickets() {
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

		return data;
	}

}
