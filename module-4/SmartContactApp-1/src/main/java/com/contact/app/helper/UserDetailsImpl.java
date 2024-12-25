package com.contact.app.helper;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.contact.app.entities.User;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

	private List<GrantedAuthority> authorities;
	private String password;
	private String username;
	public UserDetailsImpl(User user) {
		
		username=user.getEmail();
		password=user.getPassword();
		authorities=user.getRole().stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
		
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return authorities;
	}

	@Override
	public String getPassword() {
		
		return password;
	}

	@Override
	public String getUsername() {
		
		return username;
	}

}
