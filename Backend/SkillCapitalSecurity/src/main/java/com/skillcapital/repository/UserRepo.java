package com.skillcapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillcapital.model.Users;

public interface UserRepo extends JpaRepository<Users, Integer>{

	Users findByUsername(String username);

}
