package com.zm.dao.impl;

import org.springframework.stereotype.Component;

import com.zm.dao.IGoodsDao;
import com.zm.model.Goods;

@Component("goodsdao")
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {

}
