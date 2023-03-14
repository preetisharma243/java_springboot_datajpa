package com.psit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psit.response.UserAssesmentResponse;
import com.psit.serviceImpl.UserServiceImpl;

@RestController
public class UserController {
	
	
	@Autowired
	private UserServiceImpl userService;
	//fwd slash and star and enter
	
	/*
	 * @code finding users with assesment status (table included user and assesmenttrigger in pgrip db
	 * 
	 * 
	 */
	
	//http://localhost:8080/findUser?pageNo=1&pageSize=10&direction="ASC"&sortBy=first_name
	
	@GetMapping("/findUser")
	public ResponseEntity<?> findAllUser(@RequestParam(required = false, defaultValue = "1") Integer pageNo,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(required = false,defaultValue = "ASC")String direction,
			@RequestParam(required = false,defaultValue = "id")String sortBy){
		
		List<UserAssesmentResponse> findAllUser = userService.findAllUser(pageNo,pageSize,direction,sortBy);
		
		return ResponseEntity.ok(findAllUser);
		
		
		
	}

}
