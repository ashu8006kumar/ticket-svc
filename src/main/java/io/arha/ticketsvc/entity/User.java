package io.arha.ticketsvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username", nullable = false, unique = true)
	private String username;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "enable")
	private Boolean enable;

	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "last_updated")
	private Date lastUpdated;

}
