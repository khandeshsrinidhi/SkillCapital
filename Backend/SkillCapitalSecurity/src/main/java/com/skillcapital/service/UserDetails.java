package com.skillcapital.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.skillcapital.model.UserPrinciple;
import com.skillcapital.model.Users;
import com.skillcapital.repository.UserRepo;

@Service
public class UserDetails implements UserDetailsService {
	
	@Autowired
	UserRepo repo;

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)throws UsernameNotFoundException 
	{
		Users user = repo.findByUsername(username);
		
		if(user == null)
		{
			System.out.println("User not found");
			throw new UsernameNotFoundException("user not found");
		}
		return new UserPrinciple(user);
	}

}
