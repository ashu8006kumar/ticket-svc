package io.arha.ticketsvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "register_users")
public class RegisterUsers {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "register_link_id", nullable = false)
	private String registerLinkId;

	@Column(name = "enpiredOn", nullable = false)
	private Date expiredOn;

}
