package com.zm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.zm.model.A;
import com.zm.model.C;
import com.zm.model.Goods;
import com.zm.service.IGoodsService;
import com.zm.service.IUserService;

@Controller
@RequestMapping("goods")
public class GoodsAction {

	@Resource
	private IGoodsService goodsservice;

	public IGoodsService getGoodsservice() {
		return goodsservice;
	}

	public void setGoodsservice(IGoodsService goodsservice) {
		this.goodsservice = goodsservice;
	}
	
	
	public  List<Goods> query( C good){
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		IGoodsService goodsservice=(IGoodsService) ctx.getBean("goodsservice");
		
		long num=good.getA();
		System.out.println(good.getA());
		List<Goods> glist=goodsservice.limitq(num);
		return glist;
	} 
	public static void main(String[] args){
		C c=new C();
		c.setA(1);
		GoodsAction g=new GoodsAction();
		List<Goods> glist=g.query(c);
		System.out.println(glist.get(0).getBrand());
	}
	@RequestMapping("a")
	public String a(@RequestBody A g){
		System.out.println(g.getA());
		return "manager";
	}
	
}
