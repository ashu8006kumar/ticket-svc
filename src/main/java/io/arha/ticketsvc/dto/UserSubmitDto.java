package io.arha.ticketsvc.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.arha.ticketsvc.enums.RoleType;

public class UserSubmitDto {
	private Long id;
	@NotBlank
	@NotNull
	@Email
	private String username;
	@NotBlank
	@NotNull
	private String name;
	private RoleType roles;
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
	public RoleType getRoles() {
		return roles;
	}
	public void setRoles(RoleType roles) {
		this.roles = roles;
	}
	public UserSubmitDto(Long id, @NotBlank @NotNull @Email String username, @NotBlank @NotNull String name,
			RoleType roles) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.roles = roles;
	}
	public UserSubmitDto() {
		
	}
	
}
