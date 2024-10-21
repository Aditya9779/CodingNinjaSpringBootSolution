package com.CodingNinjas.TaxEase.security;

import com.CodingNinjas.TaxEase.model.User;
import com.CodingNinjas.TaxEase.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository)
	{
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user= this.userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
		return user;
		
	}

	
}
