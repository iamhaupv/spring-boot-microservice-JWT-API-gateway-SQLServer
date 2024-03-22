package com.example.PhamVanHau_User.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.PhamVanHau_User.entity.User;
import com.example.PhamVanHau_User.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v2")
public class UserController {
	@Autowired
	private UserService service;
	@GetMapping("/users")
	public List<User> getAllUser(){
		return service.getAllUser();
	}
	@PostMapping("/user")
	public User add(@Valid @RequestBody User user) {
		return service.add(user);
	}
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable("id") int id) {
		service.delete(id);
		return "Successly";
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable("id") int id) {
		return service.getUserById(id);
	}
	@PutMapping("/user/{id}")
	public User update(@Valid @PathVariable("id")int id, @RequestBody User user) {
		return service.update(id, user);
	}
}
