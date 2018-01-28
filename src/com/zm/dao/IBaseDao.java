package com.zm.dao;

import java.util.List;

public interface IBaseDao<T> {
	
	public void add(T entity);

	public void delet(Long id);

	public void update(T entity);

	public List<T> findall();

	public T getById(Long id);

	public List<T> getByIds(Long[] ids);
}
