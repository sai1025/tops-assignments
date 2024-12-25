package com.contact.app.controller;


import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import com.contact.app.entities.User;
import com.contact.app.helper.JwtUtil;
import com.contact.app.helper.Message;
import com.contact.app.repository.UserRepository;
import com.contact.app.service.EmailService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestParam;


import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	EmailService emailService;
	
	@GetMapping(value={"/home","/"})
	public String home( Model model)
	{
		model.addAttribute("title", "Home:Smart Contact Manager");
		return "home";
	}
	
	
	@GetMapping("/about")
	public String about( Model model)
	{
		model.addAttribute("title", "about:Smart Contact Manager");
		return "about";
	}
	@GetMapping("/login")
	public String login(Model model) {
		
		model.addAttribute("title", "Login");
		return "login";
	}
	@GetMapping("/forgot")
	public String forgot_password()
	{
		return "forgot_password";
	}
	@PostMapping("/send_otp")
	public String sendOTP(@RequestParam String email,HttpSession session)
	{
		System.out.println(email);
		
		
		if(userRepository.findUserByEmail(email)==null)
		{
			session.setAttribute("message",new Message("enter correct email associated with scm","alert-danger"));
			return "forgot_password";
		}
		
		
		Random random=new Random(1000);
		
		int otp=random.nextInt(9999);
		String text="your Otp:"+otp;
		String subject="mail from SCM";
		
		boolean emailsent=emailService.sendEmail(email, text, subject);
		
		if(emailsent)
		{
			session.setAttribute("otp",otp);
			session.setAttribute("email",email);
			session.setAttribute("message",new Message("for your,security,we have sent code to your email:"+email.charAt(0)+"*****@gmail.com","alert-success"));
		}
		
		return "enter_otp";
	}
	@PostMapping("/verify_otp")
	
	public String getOTP(@RequestParam int otp,HttpSession httpSession)
	{
		System.out.println(httpSession.getAttribute("email"));
		System.out.println(otp);
		
		if(otp==(int)httpSession.getAttribute("otp"))
		{
			System.out.println("otp verified");
		}
		return "change_password";
	}
	@PostMapping("/save_password")
	public String savePassword(@RequestParam String password,HttpSession session)
	{
		
		String email=(String)session.getAttribute("email");
		System.out.println(email);
		User user=userRepository.findUserByEmail(email).orElse(null);
		user.setPassword(encoder.encode(password));
		
		
		userRepository.save(user);
		
		return "login";
	}
	@GetMapping("/signup")
	public String signup(Model model) {
	
		model.addAttribute("title", "Register");
		model.addAttribute("user", new User() );
		return "signup";
	}
	@GetMapping("/auth")
	public String verifyToken(@RequestParam String token,HttpSession session)
	{
		String email=JwtUtil.validateToken(token);
		User user=userRepository.findUserByEmail(email).orElse(null);
		if(user!=null)
		{
			
				user.setVerified(true);
				user.setEnabled(true);
				userRepository.save(user);
				
				session.setAttribute("message",new Message("your account is verified successfully","alert-success"));
				return "success_token";
		}
			
			session.setAttribute("message",new Message("your account failed to verify","alert-danger"));
			return "error_token";
		
		
	}
	@PostMapping("/process_form")
	public String processForm(@Valid @ModelAttribute User user,BindingResult bindingResult, @RequestParam(defaultValue = "false") boolean agreement,Model model,HttpSession session) {
		//TODO: process POST request
		if(bindingResult.hasErrors())
		{
			return "signup";
		}
		
		try{
			
			if(!agreement)
			{
				throw new Exception("accept terms and conditions");
			}
			String token=JwtUtil.generateToken(user.getEmail());
			String content="<p>Thank you for signing up for SCM.<br>"
						+ "Verify your email address by clicking the link below</p>"
						+ "<br><br> <a href='http://localhost:8080/auth?token="+token+"'> Confirm my account</a>"+"<br><br>"
						;
			emailService.sendEmail(user.getEmail(), content," Welcome to SCM");
			
			
			user.setRole(List.of("ROLE_USER"));
			user.setEnabled(true);
			user.setImageurl("default.png");
			user.setPassword(encoder.encode(user.getPassword()));
			
			userRepository.save(user);
			
			session.setAttribute("message",new Message("Verification link sent to your email!!","alert-success"));
			model.addAttribute("user", new User());
		}
		catch(Exception e)
		{
			if(e.getMessage().contains("Duplicate entry"))
				session.setAttribute("message", new Message(" email already exists,enter unique value","alert-danger"));
			else
			session.setAttribute("message", new Message("Something went wrong!:"+e.getLocalizedMessage(),"alert-danger"));
		}
		return "signup";
	}
	
	
	
}
