package com.psit.serviceImpl;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psit.dto.CompanyDTO;
import com.psit.entity.Company;
import com.psit.entity.Department;
import com.psit.repository.CompanyRepository;
import com.psit.repository.DepartmentRepository;
import com.psit.service.CompanyService;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	private static final Logger log = LoggerFactory.getLogger(CompanyServiceImpl.class);

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CompanyRepository compRepository;
	
	@Autowired
	private DepartmentRepository deptRepository;
	

	@Override
	@Transactional
	public CompanyDTO saveCompany(CompanyDTO companyDto) {
		/*Department dept=new Department();
		dept.set_Active(true);
		dept.setCreated(LocalDateTime.now());
		dept.setDptCode("D1");
		dept.setDptName("javaWeb");
		deptRepository.save(dept);*/
		
		log.info("companyDTO {}:" ,companyDto);
		
		mapper.getConfiguration().setAmbiguityIgnored(true);
		Company company = mapper.map(companyDto, Company.class);
		
		Company company2 = compRepository.save(company);
		
		CompanyDTO companyDTO2 = mapper.map(company2, CompanyDTO.class);
		
		
		return companyDTO2;
	}
	

}
