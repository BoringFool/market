package com.zm.controller;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zm.service.IGoodsService;

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
	
	@RequestMapping("query")
	public String query(String num){
		int a;
		a=(Integer.parseInt(num)-1)*6;
		String sql="select * from goods limit "+ a +",6";
		
		return "aa";
	} 
}
