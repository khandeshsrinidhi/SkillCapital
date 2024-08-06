package com.skillcapital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillcapital.Model.UserData;
import com.skillcapital.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<UserData> getAllUsers() {
		
		return repo.findAll();
	}

	public UserData getUserById(int id) {
		return repo.findById(id).orElse(null);
	}

	public UserData addUser(UserData user)
	{
		return repo.save(user);
	}

	public UserData UpdateUser(UserData user) 
	{
		return repo.save(user);
	}

	public void DeleteUserById(int id) 
	{
	   repo.deleteById(id);
	}
}
