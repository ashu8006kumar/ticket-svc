package io.arha.ticketsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
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
		
		JavaMailSenderImpl javaMailSender= new JavaMailSenderImpl(); 
		javaMailSender.setHost(emailProps.getHost());
		javaMailSender.setPort(emailProps.getPort());
		javaMailSender.setUsername(emailProps.getUsername());
		javaMailSender.setPassword(emailProps.getPassword());
		
		
		///
		SimpleMailMessage message= new SimpleMailMessage();
		message.setTo("ashu8006kumar@gmail.com");
		message.setFrom("tickectingapp@gmail.com");
		message.setSubject("dyummy message ");
		message.setText("Hi user,\nthis is a dummy message.");
		
		
		javaMailSender.send(message);
		
		
		
		
		
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
