package com.skillcapital.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import com.skillcapital.model.Users;
import com.skillcapital.repository.UserRepo;

@Service
public class UserServices {
	
	@Autowired
	private UserRepo repo;
	
	@Autowired
	private JWTServices jwtservice;
	
	@Autowired
	AuthenticationManager authManager;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	public Users register(Users user)
	{
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}
	public List<Users> getAllUsers() {
		
		return repo.findAll();
	}

	public Users getUserById(int id) {
		return repo.findById(id).orElse(null);
	}

	public Users addUser(Users user)
	{
		return repo.save(user);
	}

	public Users UpdateUser(Users user) 
	{
		return repo.save(user);
	}

	public void DeleteUserById(int id) 
	{
	   repo.deleteById(id);
	}
	
	public String verify(Users user) {
	   Authentication authentication =  
			   authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword()));
	   if(authentication.isAuthenticated())
	   {
		   return jwtservice.generateToken(user.getUsername());
	   }
	   return "fail";
	}

}
