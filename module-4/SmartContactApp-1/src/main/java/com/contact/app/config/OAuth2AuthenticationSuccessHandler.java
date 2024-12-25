package com.contact.app.config;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.contact.app.entities.User;
import com.contact.app.repository.UserRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class OAuth2AuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	Logger logger=LoggerFactory.getLogger(OAuth2AuthenticationSuccessHandler.class);
	@Autowired
	UserRepository repository;
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		
		
		logger.info("OAuth2AuthenticationSuccessHandler");
		
		OAuth2User oAuth2User= (OAuth2User)authentication.getPrincipal();
		oAuth2User.getAttributes().forEach((key,val)->logger.info(key+":"+val));
		
		OAuth2AuthenticationToken oauth2AuthenticationToken=(OAuth2AuthenticationToken)authentication;
		String authorizedClientRegistrationId = oauth2AuthenticationToken.getAuthorizedClientRegistrationId();
	
		User user=new User();
		user.setEnabled(true);
		user.setPassword("dummy");
		user.setRole(List.of("ROLE_USER"));
		
		String email = null;
		
		if(authorizedClientRegistrationId.equalsIgnoreCase("google"))
		{
			email=oAuth2User.getAttribute("email");
			user.setName(oAuth2User.getAttribute("name"));
			user.setEmail(email);
			user.setImageurl(oAuth2User.getAttribute("picture"));
			user.setAbout("this account was created using google sign in");
		}
		else if (authorizedClientRegistrationId.equalsIgnoreCase("github"))
		{
			email=oAuth2User.getAttribute("email");
			if(email==null)
				email=oAuth2User.getAttribute("login")+"@gmail.com";
			
			user.setName(oAuth2User.getAttribute("name"));
			user.setEmail(email);
			user.setImageurl(oAuth2User.getAttribute("avatar_url"));
			user.setAbout("this account was created using github sign in");

		}
		else
		{
			
		}
		
		if(repository.findUserByEmail(email)==null) {
			User user1=repository.save(user);
			logger.info("user:"+user1.getEmail()+" saved to database");
		}
		
		response.sendRedirect("/user/dashboard");
	}

}
