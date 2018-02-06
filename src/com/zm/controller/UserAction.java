package com.zm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.model.User;
import com.zm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserAction {
	
	@Resource
	private IUserService userservice;
	
	
	public IUserService getSuerservice() {
		return userservice;
	}


	public void setSuerservice(IUserService suerservice) {
		this.userservice = suerservice;
	}


	@RequestMapping("/register")
	public String register(User u){
		String msg=userservice.save(u);
		System.out.println(msg);
		return "4";
	}
}
