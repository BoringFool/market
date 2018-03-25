package com.zm.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zm.model.Goods;
import com.zm.model.OrderList;
import com.zm.model.User;
import com.zm.service.IGoodsService;
import com.zm.service.IOrderListService;
import com.zm.service.IUserService;

public class ssh {

	@Test
	@SuppressWarnings("resource")
	public void test() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IUserService userservice=(IUserService) ctx.getBean("userservice");
		User u=new User();
		u.setName("zz");
		String a=userservice.save(u);
		System.out.println(a);
	}
	
	@Test
	@SuppressWarnings("resource")
	public void test_goods() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		Goods g=new Goods();
		g.setName("电脑");
		g.setBrand("Dell");
		g.setColor("black");
		g.setImgeurl("url:null");
		g.setNumber(1l);
		g.setPrice(4000.00);
		g.setSize("M");
		g.setStore("LuLuStore");
		goodsservice.save(g);
		System.out.println(g);
	}
	
	@Test
	@SuppressWarnings("resource")
	public void test_orderlist() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IOrderListService orderlistservice=(IOrderListService) ctx.getBean("orderlistservice");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		Goods g=goodsservice.getById(1l);
		OrderList o_l=new OrderList();
 		o_l.addGood(g);
		orderlistservice.save(o_l);
		System.out.println(o_l.getId());
	}

}
