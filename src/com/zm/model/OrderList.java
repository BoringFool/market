package com.zm.model;

import javax.persistence.ManyToMany;

public class OrderList {
	@ManyToMany
	private Goods goods;

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}
}
