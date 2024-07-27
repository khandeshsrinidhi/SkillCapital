package com.skillcapital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillcapital.Model.UserData;
import com.skillcapital.service.UserService;

@CrossOrigin
@RestController // since it is data
@RequestMapping("/skillcapital") // mapping to particular url
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/loginPage")
	public ResponseEntity<List<UserData>> getAllUsers(){
		return new ResponseEntity<>(service.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/loginPage/{id}")
	public ResponseEntity<UserData> getUserById(@PathVariable int id){
		UserData user = service.getUserById(id);
		if(user !=null)
		{
			return new ResponseEntity<>(user,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(user,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/loginPage/add")
	public ResponseEntity<UserData> addUser(@RequestBody UserData user)
	{
		return new ResponseEntity<>(service.addUser(user),HttpStatus.OK);
	}
	
	@PutMapping("/loginPage/update")
	public ResponseEntity<UserData> UpdateUser(@RequestBody UserData user)
	{
		return new ResponseEntity<>(service.UpdateUser(user),HttpStatus.OK);
	}

	@DeleteMapping("/loginPage/{id}")
	public String DeleteUser(@PathVariable int id) {
		service.DeleteUserById(id);
		return "User Deleted Sucessfully";
	}
}
