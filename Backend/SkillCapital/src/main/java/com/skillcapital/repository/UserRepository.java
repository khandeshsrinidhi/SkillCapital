package com.skillcapital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skillcapital.Model.UserData;

@Repository
public interface UserRepository extends JpaRepository<UserData, Integer> {

}
