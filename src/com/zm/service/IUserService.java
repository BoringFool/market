package com.zm.service;

import java.util.List;

import com.zm.model.User;

public interface IUserService {
	public String save(User u);
	public void delet(User u);
	public void update(User u);
	public List<User> findall();
	public User getByid(Long id);
	public List<User> getByids(Long[] ids);
}