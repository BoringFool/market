package com.zm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zm.model.C;
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
	@ResponseBody
	public List<Goods> query(@RequestBody Goods c) {
		List<Goods> glist = goodsservice.limitq(c.getId(),5);
		return glist;
	}
	
	@RequestMapping("showquery")
	@ResponseBody
	public List<Goods> showquery(@RequestBody C c) {
		List<Goods> glist = goodsservice.limitq(c.getA(),c.getB());
		return glist;
	}

	@RequestMapping("count")
	@ResponseBody
	public C count() {
		Long count=goodsservice.count();
		C c=new C();
		c.setA(count);
		return c;
		
	}
	@RequestMapping("add")
	@ResponseBody
	public Goods add(@RequestBody Goods c) {

		goodsservice.save(c);
		Goods g =c;
		return g;
		
		 
		
	}
}
