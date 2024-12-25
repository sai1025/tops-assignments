package com.contact.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.contact.app.entities.User;
import com.contact.app.helper.UserDetailsImpl;
import com.contact.app.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("username:"+username);
		User user = repository.findUserByEmail(username).orElse(null);
		if(user!=null)
		System.out.println("found user");
		else
			System.out.println("found user");
		System.out.println("inside:"+user);
		return new UserDetailsImpl(user);
	}

}
