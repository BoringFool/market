package com.zm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.service.IOrderListService;

@Service("orderlistservice")
@Transactional
public class OrderListService implements IOrderListService {

	@Resource
	private IOrderListService orderlistservice;

	public IOrderListService getOrderlistservice() {
		return orderlistservice;
	}

	public void setOrderlistservice(IOrderListService orderlistservice) {
		this.orderlistservice = orderlistservice;
	}
}
