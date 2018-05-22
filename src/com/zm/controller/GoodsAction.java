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
		int first=(int) ((c.getId()-1)*5);
		List<Goods> glist = goodsservice.limitq(first,5);
		System.out.println(glist);
		return glist;
	}
	
	@RequestMapping("showquery")
	@ResponseBody
	public List<Goods> showquery(@RequestBody C c) {
		int first=(c.getA()-1)*50;
		List<Goods> glist = goodsservice.limitq(first,c.getB());
		System.out.println(glist);
		for(Goods g:glist){
			 System.out.println(g.getId());
		}
		return glist;
	}

	@RequestMapping("count")
	@ResponseBody
	public C count() {
		long count=goodsservice.count();
		C c=new C();
		c.setA((int) count);
		return c;
		
	}
	@RequestMapping("add")
	@ResponseBody
	public Goods add(@RequestBody Goods c) {
		goodsservice.save(c);
		Goods g =c;//save后c的状态改变，拥有了id
		return g;
		
		 
		
	}
}
