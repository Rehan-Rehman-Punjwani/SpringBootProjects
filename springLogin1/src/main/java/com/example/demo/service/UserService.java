package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository repo;

	public void saveUser(User user) {
		
	
		repo.save(user);
	}
	public List<User> showUser() {
		List<User> users = new ArrayList<User>();
		for (User user: repo.findAll()) {
			users.add(user);
		}
	return users;
	}
	public void deleteUser(int id){
	
		User user = repo.findById(id).orElse(null);
		repo.delete(user);
	}
	public User UpdateUser(int id) {
		User user = repo.findById(id).orElse(null);
		return user;
	}
	public User findByUsernameAndPassword(String username, String password) {
		 return  repo.findByusernameAndPassword(username, password);
		
	}
}
