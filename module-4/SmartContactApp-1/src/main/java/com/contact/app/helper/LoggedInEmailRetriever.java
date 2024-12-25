package com.contact.app.helper;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class LoggedInEmailRetriever {

	public static String retrieveEmail(Authentication authentication)
	{
		String email=null;
		if(authentication instanceof OAuth2AuthenticationToken)
		{
			OAuth2AuthenticationToken oauth2AuthenticationToken=(OAuth2AuthenticationToken)authentication;
			String authorizedClientRegistrationId = oauth2AuthenticationToken.getAuthorizedClientRegistrationId();
		
			OAuth2User oAuth2User= (OAuth2User)authentication.getPrincipal();
			
			if(authorizedClientRegistrationId.equalsIgnoreCase("google"))
			{
				System.out.println("getting email from google");
				email= oAuth2User.getAttribute("email");
			}
			else if(authorizedClientRegistrationId.equalsIgnoreCase("github"))
			{
				System.out.println("getting email from github");
				
				email=oAuth2User.getAttribute("email");
				if(email==null)
					email=oAuth2User.getAttribute("login")+"@gmail.com";
				
			}
		}
		else
		{
				System.out.println("getting email from database");
				email=authentication.getName();
		}
		
	
		
		return email;
	}
}
