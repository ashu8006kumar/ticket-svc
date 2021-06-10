package io.arha.ticketsvc.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import io.arha.ticketsvc.enums.RoleType;
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
		List<SimpleGrantedAuthority> authorities= new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(RoleType.ROLE_USER.name())); 
		authorities.add(new SimpleGrantedAuthority(RoleType.ROLE_ADMIN.name()));
		return new User(user.getUsername(), user.getPassword(), authorities);
	}

	io.arha.ticketsvc.entity.User currentUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		return userRepository.findByUsername(user.getUsername());
	}

}
