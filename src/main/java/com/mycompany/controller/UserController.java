package com.mycompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.service.UserSevice;

@Controller
public class UserController {

	 @Autowired
	 private UserSevice userService;
	 
	 @RequestMapping("/users")
	 public String users(Model model){
		 System.out.println("inside user Controller");		 
		 model.addAttribute("users",userService.findAll());
		 
		 return "users";
	 }
	 
	 @RequestMapping("/users/{id}")
	 public String details(Model model,@PathVariable("id")Integer id){
		 
		// model.addAttribute("user", userService.findOne(id));
		 model.addAttribute("user",userService.findOneWithBlogs(id));
		 
		 return "user-detail";
	 }
	               
}          
