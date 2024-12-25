package com.contact.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.contact.app.entities.User;
import com.contact.app.helper.LoggedInEmailRetriever;
import com.contact.app.repository.UserRepository;

@ControllerAdvice
public class RootController {

	@Autowired
	UserRepository userRepository;
	
	@ModelAttribute
	public void  addLoggedinUserInfo(Model model,Authentication authentication)
	{
		if(authentication==null)
			return;
		String email=LoggedInEmailRetriever.retrieveEmail(authentication);
		System.out.println("i'm executed first");
		User user = userRepository.findUserByEmail(email).orElse(null);
		System.out.println(user);
		
		model.addAttribute("user", user);
	
	}
}
