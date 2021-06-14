package io.arha.ticketsvc.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import io.arha.ticketsvc.dto.UserDto;
import io.arha.ticketsvc.entity.User;
import io.arha.ticketsvc.entity.UserRole;
import io.arha.ticketsvc.enums.RoleType;
import io.arha.ticketsvc.repository.UserRepository;
import io.arha.ticketsvc.repository.UserRoleRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Override
	public List<UserDto> findAll() {
		return userRepository.findAll().stream().map(this::mapUser).collect(Collectors.toList());
//		List<UserDto> userDtos = new ArrayList<>();
//		for (Iterator<User> iterator = uses.iterator(); iterator.hasNext();) {
//			User user = 
//			List<UserRole> userRoles = userRoleRepository.findAllByUser(user);
//			List<RoleType> roles = userRoles.stream().map(userRole -> userRole.getRole().getName())
//					.collect(Collectors.toList());
//			userDtos.add(convert(iterator.next()));
//		}
//		return userDtos;
	}

	@Override
	public UserDto findAllById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			return mapUser(userOptional.get());
		} else {
			throw new RuntimeException("User not found");
		}

	}

	private UserDto mapUser(User user) {
		List<UserRole> userRoles = userRoleRepository.findAllByUser(user);
		List<RoleType> roles = userRoles.stream().map(userRole -> userRole.getRole().getName())
				.collect(Collectors.toList());
		return new UserDto(user.getId(), user.getUsername(), user.getName(), user.getEnable(), roles);
	}

}
