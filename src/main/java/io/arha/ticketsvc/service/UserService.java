package io.arha.ticketsvc.service;

import java.util.List;

import io.arha.ticketsvc.dto.UserDto;

public interface UserService {

	List<UserDto> findAll();

	UserDto findAllById(Long id);

}
