package com.zm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zm.model.C;
import com.zm.model.Goods;
import com.zm.myuntil.FileUpload;
import com.zm.myuntil.StringArray;
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
	/*
	 * 缺少处理imageurl的方法，暂时只能使用一个图片地址的imageurl
	 * */
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
	public C addg(@RequestBody Goods c, HttpServletRequest req) {
		String st = (String) req.getSession().getAttribute("username");
		c.setStore(st);
		goodsservice.save(c);
		Goods g = goodsservice.getByName(c.getName());
		// c在save后c的状态改变，拥有了id
		C m = new C();
		m.setA((int) g.getId());
		return m;
	}

	@RequestMapping("addgattr")
	@ResponseBody
	public String addgattr(@RequestBody Goods g) {
		if (g.getBrand().contains("_")){
			String fix=g.getBrand().substring(1);
			g.setBrand(fix);
			goodsservice.update(g);
			return "1";
		} else {
			Goods updateg = goodsservice.getById(g.getId());
			updateg.setBrand(g.getBrand());
			updateg.setColor(g.getColor());
			updateg.setSize(g.getSize());
			updateg.setImageurl(g.getImageurl());
			goodsservice.update(updateg);
			return "1";
		}

	}
	
	@RequestMapping("getbyid")
	@ResponseBody
	public Goods  getById(@RequestBody Goods g){
		return goodsservice.getById(g.getId());
	}
	
	
	@RequestMapping("delete")
	@ResponseBody
	public String  delete(@RequestBody Goods g){
		System.out.println("调用");
		goodsservice.delete(g.getId());
		return "1";
	}
	

	@RequestMapping("jsontest")
	@ResponseBody
	public String testjson(@RequestBody Goods g) {
		String a = g.getImageurl();
		System.out.println(a);
		// 取得数组第一个，因为会抛出异常，所以需要检查结果是否为null
		String s = StringArray.jsonget(g.getImageurl(), 0);
		if (s == null) {
			System.out.println("json字符串有问题，请检查！");
		}
		return "1";
	}

	@RequestMapping("stringtest")
	@ResponseBody
	public Goods stringjson(@RequestBody Goods g) {
		String b = g.getName();
		System.out.println(b);
		System.out.println(StringArray.stringToArray(b) + "\n输出的是数组\n");
		System.out.println(StringArray.ArrayToString(StringArray
				.stringToArray(b)) + "\n输出的string\n");

		Goods ngood = new Goods();
		ngood.setName(StringArray.ArrayToString(StringArray.stringToArray(b)));
		return ngood;
	}
	
	@RequestMapping("turn")
	public String turn(HttpServletRequest req){
		FileUpload.picUpdate(req);
		return "manager";
	}
	
	
	
	
}
