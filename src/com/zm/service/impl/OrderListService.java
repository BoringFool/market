package com.zm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zm.dao.IOrderListDao;
import com.zm.model.OrderList;
import com.zm.service.IOrderListService;

@Service("orderlistservice")
@Transactional
public class OrderListService implements IOrderListService {

	@Resource
	private IOrderListDao orderlistdao;

	public IOrderListDao getOrderlistdao() {
		return orderlistdao;
	}

	public void setOrderlistdao(IOrderListDao orderlistdao) {
		this.orderlistdao = orderlistdao;
	}

	@Override
	public void save(OrderList o_l) {
		orderlistdao.add(o_l);

	}
}
