package com.zm.dao;


import java.util.List;

import com.zm.model.Goods;

public interface IGoodsDao extends IBaseDao<Goods> {

	public List<Goods> limitquery(long num);
	public long countNum();
}
