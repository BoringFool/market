package com.zm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IOrderDao;
import com.zm.service.IOrderService;
@Service("orderservice")
@Transactional
public class OrderService implements IOrderService {

	@Resource
	private IOrderDao orderdao;

	public IOrderDao getOrderdao() {
		return orderdao;
	}

	public void setOrderdao(IOrderDao orderdao) {
		this.orderdao = orderdao;
	}
}