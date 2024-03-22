package com.example.PhamVanHau_User.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.PhamVanHau_User.entity.User;

@Service
public interface UserService {
	public List<User> getAllUser();
	public User add(User user);
	public String delete(int id);
	public User update(int id, User user);
	public User getUserById(int id);
}
