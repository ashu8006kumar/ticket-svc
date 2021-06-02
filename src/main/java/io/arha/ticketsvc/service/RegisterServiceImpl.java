package io.arha.ticketsvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.arha.ticketsvc.dto.RegisterDto;
import io.arha.ticketsvc.entity.RegisterUser;
import io.arha.ticketsvc.repository.RegisterUserRepository;
import io.arha.ticketsvc.repository.UserRepository;
import io.arha.ticketsvc.util.Util;

@Service
public class RegisterServiceImpl implements RegisterServcie {

	@Autowired
	private UserRepository userRepository; 
	@Autowired
	private Util  util;
	@Autowired
	private RegisterUserRepository registerUserRepository;
	
	
	@Override
	public void registerNewUser(RegisterDto register) {
		long count =userRepository.countByUsername(register.getUsername());
		if(count<=0) {
			RegisterUser registerUser= new RegisterUser();
			registerUser.setName(register.getName());
			registerUser.setUsername(register.getUsername());
			registerUser.setPassword(register.getPassword());
			registerUser.setRegisterLinkId(util.getUniqueCode());
			registerUser.setExpiredOn(util.addDays(2));
			registerUserRepository.save(registerUser); 
		}else {
			throw new RuntimeException("User already exits!");
		} 
	}

}
