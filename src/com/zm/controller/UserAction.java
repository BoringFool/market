package com.zm.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public @ResponseBody Long r1egister(@RequestBody User u) {
		User user=userservice.getByName(u.getName());
		if(user==null) {
			userservice.save(u);
			return 1l;
		}else {
			return 0l;
		}
	}
	
	/*
	 * ��֤��½�����洢��½״̬
	 * */
	@RequestMapping("/in")
	public @ResponseBody Long in(@RequestBody User u,HttpServletRequest req) {
		Long tof;
		User user = userservice.getByName(u.getName());
		if (user == null) {
			return tof = 3l;
		} else {
			if (u.getPassword().equals(user.getPassword())) {
				tof = 1l;
				req.getSession().setAttribute("logoin","ok");
			} else {
				tof = 0l;
			}
			return tof;
		}

	}
}
