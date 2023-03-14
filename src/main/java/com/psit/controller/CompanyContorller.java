package com.psit.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.psit.dto.CompanyDTO;
import com.psit.repository.CompanyRepository;
import com.psit.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyContorller {
	
	private static final Logger log = LoggerFactory.getLogger(CompanyContorller.class);

	
	@Autowired
	private CompanyService compService;
	
	@PostMapping("/saveComp")
	public ResponseEntity<?> saveCompanyDetails(@RequestBody CompanyDTO companyDto){
		log.info("Rest request processing to save company deatils");
		CompanyDTO company = compService.saveCompany(companyDto);
		
		return ResponseEntity.ok(company);
	}

}
