package com.zm.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.zm.dao.IGoodsDao;
import com.zm.model.Goods;

@Component("goodsdao")
public class GoodsDao extends BaseDao<Goods> implements IGoodsDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Goods> limitquery(int num) {
		String hql="From goods g";
		Query query=getSession().createQuery(hql);
		return query.setFirstResult(0).setMaxResults(5).list();
	}

}
