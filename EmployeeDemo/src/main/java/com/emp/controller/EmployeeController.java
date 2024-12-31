package com.emp.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.emp.repository.EmployeeRepository;
import com.emp.service.CloudImageService;

import jakarta.servlet.http.HttpSession;

import com.emp.dto.LoginDTO;
import com.emp.entities.Employee;
import com.emp.helper.Message;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	 private final EmployeeRepository employeeRepository;
	 private final CloudImageService cloudImageService;

	    public EmployeeController(EmployeeRepository employeeRepository) {
	        this.employeeRepository = employeeRepository;
			this.cloudImageService = new CloudImageService();
	       
	    }
	
	@PostMapping("/authenticate")
	public String login(@ModelAttribute LoginDTO loginDto,Model model,HttpSession session) {
		
		System.out.println(loginDto);
		Optional<Employee> empByEmail = employeeRepository.findByEmail(loginDto.getEmail());
		if(empByEmail.isPresent())
		{
			if(empByEmail.get().getPassword().equals(loginDto.getPassword()))
			{
				model.addAttribute("employee", empByEmail);
				return "view_employee";
			}
			else
				session.setAttribute("message",new Message("eter correct password!","alert-danger"));
			
		}
		else
			session.setAttribute("message",new Message("eter correct email id!","alert-danger"));
		
		
		return "home";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute Employee employee,@RequestParam("profile_picture") MultipartFile file,HttpSession session)
	{
		System.out.println(employee);
		
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		
		String uploadImageURL = cloudImageService.uploadImage(file);
		employee.setImageUrl(uploadImageURL);
		
		Employee save = employeeRepository.save(employee);
		
		if(save!=null) {
			session.setAttribute("message",new Message("employee registered successfully!","alert-success"));
			return "home";
		}
		else {
			session.setAttribute("message",new Message("employee registered successfully!","alert-danger"));
			
		return "signup";
		}
	}

	 @GetMapping("/department/{department}")
	 @ResponseBody
	 public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
	        return employeeRepository.findByDepartment(department);
	    }
}
