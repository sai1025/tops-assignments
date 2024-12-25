package com.contact.app.controller;


import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.contact.app.entities.Contact;
import com.contact.app.entities.User;
import com.contact.app.helper.FileHelper;
import com.contact.app.helper.LoggedInEmailRetriever;
import com.contact.app.helper.Message;
import com.contact.app.repository.ContactRepository;
import com.contact.app.repository.UserRepository;
import com.contact.app.service.CloudImageService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	FileHelper fileHelper;
	
	@Autowired
	CloudImageService cloudImageService;
	
	@PostMapping("/create_order")
	@ResponseBody
	public String createOrder(@RequestBody Map<String,Object> data) {
		System.out.println("ajax req received");
		System.out.println(data);
		
		try {
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_Zu5XqFUMQpn9bZ","DRvEc0ReQI9QkwIKHL8u6Mbz");
			
			int amt=Integer.parseInt(data.get("price").toString());
			JSONObject jsonObject=new JSONObject();
			jsonObject.put("amount",amt*100);
			jsonObject.put("currency","INR");
			jsonObject.put("receipt","txn_223454");
			Order order = razorpayClient.orders.create(jsonObject);
			
			System.out.println(order);
			return order.toString();
			
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@PostMapping("/process_contact")
	public String processContact(@ModelAttribute Contact contact,@RequestParam("profile_picture") MultipartFile file, Authentication authentication,Model model,HttpSession session )
	{
		System.out.println(contact);
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		try {
			
			if(file.isEmpty())
			{
				 throw new Exception(" please choose file to upload");
			}
			if(!file.getContentType().equals("image/jpeg"))
			{
				 throw new Exception(" choose jpeg/jpg file format");
			}
			
			//fileHelper.fileUpload(file);
			String uploadImageURL = cloudImageService.uploadImage(file);
				
			String email=LoggedInEmailRetriever.retrieveEmail(authentication);
			
			User user=userRepository.findUserByEmail(email).orElse(null);
			
			contact.setUser(user);
			contact.setImage(uploadImageURL);
			user.getContacts().add(contact);
			
			userRepository.save(user);
			session.setAttribute("message",new Message("contact added successfully","alert-success"));
			
		}
		catch(Exception e)
		{
			session.setAttribute("message",new Message("something went wrong"+e.getLocalizedMessage(),"alert-danger"));
			
		}
		
		return "user/add_contact";
	}
	
	@GetMapping("/add_contact")
	public String addContact(Model model)
	{
		model.addAttribute("contact",new Contact());
		return "user/add_contact";
	}
	@GetMapping("/remove")
	@ResponseBody
	public String onDelete() {
		System.out.println("clicked on delete");
		return "clicked on delete";
	}
	@ResponseBody
	@GetMapping("/hello")
	public String sayHello()
	{
		return "Hello!";
	}
	
	@GetMapping("/remove/{id}")
	@Transactional
	public String deleteContact(@PathVariable int id,Authentication authentication,Model model)
	{
		System.out.println(id);
		
		//contactRepository.findById(id).orElseThrow(()->new RuntimeException("no such contact found"));
		contactRepository.deleteById(id);
		
		

		return "redirect:/user/view_contacts/0";
	}
	
	@GetMapping("/view_contacts/{page}")
	public String getAllContacts(@PathVariable int page,Authentication authentication,Model model)
	{
		String email=LoggedInEmailRetriever.retrieveEmail(authentication);
		User user = userRepository.findUserByEmail(email).orElse(null);
		
		
		Pageable pageable = PageRequest.of(page, 4);
		Page<Contact> contacts = contactRepository.findContactsByUserId(user.getId(),pageable);
		
		model.addAttribute("contacts", contacts);
		model.addAttribute("current_page", page);
		model.addAttribute("total_pages", contacts.getTotalPages());
		return "user/view_contact";
	}
	@PostMapping("/dashboard")
	public String dashboard(Model model)
	{
		
		model.addAttribute("title", "User-DashBoard");
					
		return "user/dashboard";
	}
	@GetMapping("/dashboard")
	public String dashboard1(Model model)
	{
		
		model.addAttribute("title", "User-DashBoard");

		return "user/dashboard";
	}
	
	@GetMapping("/profile")
	public String profile(Authentication authentication,Model model)
	{
		
		String email=LoggedInEmailRetriever.retrieveEmail(authentication);
		User user = userRepository.findUserByEmail(email).orElse(null);

		model.addAttribute("user", user);
		model.addAttribute("title", "User-profile");
		
		return "user/profile";
	}
	
	@PostMapping("/profile")
	public String profile1(Model model)
	{

		model.addAttribute("title", "User-profile");
		
		return "user/profile";
	}
}
