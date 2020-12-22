package com.rktirtho.chat.controller;

import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rktirtho.chat.userstorage.UserStorage;

@RestController
public class UserController {
	
	@GetMapping("registration/{username}")
	public  ResponseEntity<Void> register (@PathVariable String username){
		System.out.println("Handeling registration "+username);
		try {
			UserStorage.getInstance().setUsers(username);
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/fatchalluser")
	public Set<String> fatchAll(){
		return UserStorage.getInstance().getUsers();
	}
	

}
