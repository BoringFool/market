package com.zm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IGoodsDao;
import com.zm.model.Goods;
import com.zm.service.IGoodsService;

@Service("goodsservice")
@Transactional
public class GoodsService implements IGoodsService {

	@Resource
	private IGoodsDao goodsdao;

	public IGoodsDao getGoodsdao() {
		return goodsdao;
	}

	public void setGoodsdao(IGoodsDao goodsdao) {
		this.goodsdao = goodsdao;
	}

	@Override
	public void save(Goods g) {
		goodsdao.add(g);
		
	}

	@Override
	public Goods getById(int l) {
		return goodsdao.getById(l);
		
	}
}
