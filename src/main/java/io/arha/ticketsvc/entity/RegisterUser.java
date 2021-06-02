package io.arha.ticketsvc.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "register_users")
public class RegisterUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "j_password", nullable = false)
	private String password;

	@Column(name = "register_link_id", nullable = false)
	private String registerLinkId;

	@Column(name = "enpiredOn", nullable = false)
	private Date expiredOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterLinkId() {
		return registerLinkId;
	}

	public void setRegisterLinkId(String registerLinkId) {
		this.registerLinkId = registerLinkId;
	}

	public Date getExpiredOn() {
		return expiredOn;
	}

	public void setExpiredOn(Date expiredOn) {
		this.expiredOn = expiredOn;
	}

	public RegisterUser() {
	}

}
