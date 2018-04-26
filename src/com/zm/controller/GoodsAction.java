package com.zm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.zm.model.A;
import com.zm.model.Goods;
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
	public @ResponseBody List<Goods> query(@RequestBody Goods good){
		long num=good.getId();
		List<Goods> glist=goodsservice.limitq(num);
		return glist;
	} 
	@RequestMapping("a")
	public String a(@RequestBody A g){
		System.out.println(g.getA());
		return "manager";
	}
	/*@RequestMapping("a")
	public String a(@RequestParam("a") String a){
		System.out.println(a);
		return "manager";
	}*/
}
