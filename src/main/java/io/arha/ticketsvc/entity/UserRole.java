package io.arha.ticketsvc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "user_roles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@JoinColumn(name = "role_id")
	@ManyToOne
	private Role role;
	@JoinColumn(name = "user_id")
	@ManyToOne
	private User user;
}
