package com.zm.service;

import com.zm.model.Goods;

public interface IGoodsService {

	public void save(Goods g);

	public Goods getById(long l);

	public void update(Goods g);

	public void delete(long l);

}
