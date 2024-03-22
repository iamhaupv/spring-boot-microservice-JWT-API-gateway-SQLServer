package com.example.PhamVanHau_User.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.PhamVanHau_User.entity.User;
import com.example.PhamVanHau_User.repository.UserRepository;

import jakarta.transaction.Transactional;
@Transactional
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repository;
	@Override
	public List<User> getAllUser() {
		return repository.findAll();
	}

	@Override
	public User add(User user) {
		return repository.save(user);
	}

	@Override
	public String delete(int id) {
		repository.deleteById(id);
		return "Successly";
	}

	@Override
	public User update(int id, User userNew) {
		User userOld = repository.findById(id).get();
		if(Objects.nonNull(userNew.getName()) && !"".equalsIgnoreCase(userNew.getName())) {
			return userNew;
		}
		return repository.save(userOld);
	}

	@Override
	public User getUserById(int id) {
		return repository.findById(id).get();
	}

}
