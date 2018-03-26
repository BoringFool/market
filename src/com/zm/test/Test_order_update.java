package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Order;
import com.zm.model.User;
import com.zm.service.IOrderService;
import com.zm.service.IUserService;

public class Test_order_update {

	@SuppressWarnings("resource")
	@Test
	public void test_update(){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderService orderservice=(IOrderService) ctx.getBean("orderservice");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		Order o=orderservice.getById(4l);
		User u=userservice.getById(3l);
		o.setUser(u);
		orderservice.upadte(o);
		System.out.println(o.getId());
	}
}
