package io.arha.ticketsvc.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class TicketSubmitionDto {

	@NonNull
	@NotBlank
	@Size(max=100)
	private String ticketSubject;
	private String type;
	private String description;
	private String link;

	public String getTicketSubject() {
		return ticketSubject;
	}

	public void setTicketSubject(String ticketSubject) {
		this.ticketSubject = ticketSubject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public TicketSubmitionDto() {
	}

	@Override
	public String toString() {
		return "TicketSubmitionDto [ticketSubject=" + ticketSubject + ", type=" + type + ", description=" + description
				+"]";
	}

}
