package io.arha.ticketsvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.arha.ticketsvc.dto.UserDto;
import io.arha.ticketsvc.dto.UserWrapperDto;
import io.arha.ticketsvc.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("")
	public UserWrapperDto getTicketCreatedByUserList() {
		List<UserDto> data = userService.findAll();
		UserWrapperDto userWrapperDto = new UserWrapperDto();
		userWrapperDto.setData(data);
		return userWrapperDto;
	}
	@GetMapping("/{id}")
	public UserDto get(@PathVariable Long id) {
		return userService.findAllById(id);
		 
	}

}
