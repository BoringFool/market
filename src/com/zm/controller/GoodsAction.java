package com.zm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
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
		int first = (int) ((c.getId() - 1) * 5);
		List<Goods> glist = goodsservice.limitq(first, 5);
		System.out.println(glist);
		return glist;
	}

	@RequestMapping("showquery")
	@ResponseBody
	public List<Goods> showquery(@RequestBody C c) {
		int first = (c.getA() - 1) * 50;
		List<Goods> glist = goodsservice.limitq(first, c.getB());
		System.out.println(glist);
		for (Goods g : glist) {
			System.out.println(g.getId());
		}
		return glist;
	}

	@RequestMapping("count")
	@ResponseBody
	public C count() {
		long count = goodsservice.count();
		C c = new C();
		c.setA((int) count);
		return c;

	}

	@RequestMapping("addg")
	@ResponseBody
	public C addg(@RequestBody Goods c) {
		goodsservice.save(c);
		Goods g = goodsservice.getByName(c.getName());
		// c在save后c的状态改变，拥有了id
		C m = new C();
		m.setA((int) g.getId());
		return m;
	}
	
	@RequestMapping("addgattr")
	@ResponseBody
	public void addgattr(@RequestBody Goods g){
		Goods updateg=goodsservice.getById(g.getId());
		updateg.setBrand(g.getBrand());
		updateg.setColor(g.getColor());
		updateg.setSize(g.getSize());
		updateg.setImgeurl(g.getImgeurl());
		updateg.setStore(g.getStore());
		goodsservice.update(updateg);
		
	}
	@RequestMapping("jsontest")
	public void testjson(@RequestBody Goods g){
		String a=g.getImgeurl();
		System.out.println(a);
		JSONObject aa=new JSONObject(a);
		Array arr=a
	}
}
