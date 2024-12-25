package com.contact.app.config;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import com.contact.app.service.UserDetailsServiceImpl;


@Configuration
public class SecurityConfiguration {
	
	@Autowired
	OAuth2AuthenticationSuccessHandler authenticationSuccessHandler;
	
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder encoder) {       
    	return  new UserDetailsServiceImpl();
    	
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
    	return new BCryptPasswordEncoder();
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
               .authorizeHttpRequests(requests -> requests
                       .requestMatchers("/user/**").authenticated())
               .authorizeHttpRequests(requests -> requests
                       .anyRequest().permitAll()).formLogin(formLogin ->
               formLogin.loginPage("/login")
               .usernameParameter("email")
               .passwordParameter("password")
               .loginProcessingUrl("/authenticate")
               .successForwardUrl("/user/dashboard"));
        
        http.oauth2Login(oauth->oauth.loginPage("/login").successHandler(authenticationSuccessHandler));
        
        return http.build();
              
    		   
    }
    
}
