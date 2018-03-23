package com.zm.dao.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Component;







import com.zm.dao.IUserDao;
import com.zm.model.ClassRoom;
import com.zm.model.Order;
import com.zm.model.User;

@Component("userdao")
public class UserDao extends BaseDao<User> implements IUserDao {

	@Override
	public User getByName(String name) {
		String hql = "FROM User as u WHERE u.name='" + name + "'";
		Query q = getSession().createQuery(hql);
		if (q.list().size() != 0) {
			return (User) q.list().get(0);
		} else {
			return null;
		}
	}

	@Override
	public void connect_ineer() {
		// 在使用hql语句的时候，要处处想着我们使用的是类，而不是表！！
				String hql = "from ClassRoom c,Student s where c.id=s.room.id and c.id='1'";
				
				List<ClassRoom> classes = getSession().createQuery(hql).list();
				HashSet<ClassRoom> cla=new HashSet<>(classes);
				Iterator it = cla.iterator();
				while(it.hasNext()) {
					 Object[] o=(Object[]) it.next();
					ClassRoom c=(ClassRoom)o [0];
					System.out.println(c.toString());
				}
				
				
					
	}

}
