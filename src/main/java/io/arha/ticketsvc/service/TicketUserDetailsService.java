package io.arha.ticketsvc.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.arha.ticketsvc.repository.UserRepository;

@Service
public class TicketUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		io.arha.ticketsvc.entity.User user = userRepository.findByUsername(username);
		if (user == null)
			throw new UsernameNotFoundException("User not found.");
		return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
	}

	io.arha.ticketsvc.entity.User currentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return userRepository.findByUsername(user.getUsername());
	}

}
