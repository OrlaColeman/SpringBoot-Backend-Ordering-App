package com.project.rest.webservice.Project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.rest.webservice.Project.model.User;
import com.project.rest.webservice.Project.model.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) 
		throws UsernameNotFoundException{
			
			User user = userRepository.findByUsername(username)
					.orElseThrow(() ->
					new UsernameNotFoundException("User not found with these details")
		);
		
			return UserPrinciple.build(user);	
		
		}
}
	
	

