package com.psit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psit.dto.DepartmentDTO;
import com.psit.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentCotroller {
	
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentCotroller.class);

	@Autowired
	private DepartmentService deptService;
	@PostMapping("/saveDept")
	public ResponseEntity<?> saveDepartmentDetails(@RequestBody DepartmentDTO department){
		
		log.info("Rest request for saving Department data");
		DepartmentDTO saveDepartment = deptService.saveDepartment(department);
		
		return ResponseEntity.ok(saveDepartment);
		
		
		
		
	}

}
