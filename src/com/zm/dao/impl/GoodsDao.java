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
	public List<Goods> limitquery(long num,int length) {
		
		String hql="From Goods g";
		int first=(int) ((num-1)*5);
		Query query=getSession().createQuery(hql);
		return query.setFirstResult(first).setMaxResults(length).list();
	}

	@Override
	public long countNum() {
		String hql="SELECT COUNT(*) From Goods g";
		Long count=(Long) getSession().createQuery(hql).iterate().next();
		return count;
	}

}
