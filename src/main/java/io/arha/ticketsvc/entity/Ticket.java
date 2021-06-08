package io.arha.ticketsvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import io.arha.ticketsvc.enums.TicketType;

@Entity(name = "tickets")
public class Ticket {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ticket_subject" ,nullable=false)
	private String ticketSubject;
	
	@Column(name = "ticket_description" )
	private String ticketDescription;
	
	@Column(name = "ticket_type" ,nullable=false)
	private TicketType ticketType;
	 
	@JoinColumn(name="user_created_by_id")
	@ManyToOne
	private User createdBy;
	

	@JoinColumn(name="user_worked_by_id" )
	@ManyToOne
	private User workedBy;
	

	@Column(name = "created_date")
	private Date createdDate;

	@Column(name = "last_updated")
	private Date lastUpdated;

	public Ticket() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTicketSubject() {
		return ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

}
