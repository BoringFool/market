package com.zm.dao.impl;


import org.hibernate.Query;
import org.springframework.stereotype.Component;

import com.zm.dao.IUserDao;
import com.zm.model.User;

@Component("userdao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public User getByName(String name) {
		String hql="FROM User as u WHERE u.name='"+name+"'";
		Query q=getSession().createQuery(hql);
		if(q.list().size()!=0) {
			return (User) q.list().get(0);
		}else {
			return null;
		}
	}

}
