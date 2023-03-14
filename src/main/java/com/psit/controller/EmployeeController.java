package com.psit.controller;

import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psit.dto.EmployeeDTO;
import com.psit.response.EmployeeResponse;
import com.psit.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	
	private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployeeDetails(@Valid @RequestBody EmployeeDTO employeeDto){
		log.info("Rest request for saving Employee data");
		
		EmployeeResponse empResponse = empService.saveEmployee(employeeDto);
		
		return ResponseEntity.ok(empResponse);
	}
		
		@PutMapping("/updateEmp")
		public ResponseEntity<?> updateEmployee(@RequestParam("emp_id") Long id,@RequestBody EmployeeDTO employeedto){
		log.info("Rest request to uptade employee data");
			
			
			EmployeeResponse empResponse = empService.updateEmployee(id, employeedto);
		
		return ResponseEntity.ok(empResponse);
		
	}

		@GetMapping("/search")
		public ResponseEntity<?> searchEmployee(@RequestParam("keyword") String keyword, @RequestParam(required = false, defaultValue = "1") Integer pageNo,
				@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
			Map<String, Object> map = empService.searchEmployee(keyword, pageNo, pageSize);
			return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		}
		
}
