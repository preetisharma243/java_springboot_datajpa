package com.psit.serviceImpl;

import java.time.LocalDateTime;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psit.dto.DepartmentDTO;
import com.psit.entity.Department;
import com.psit.repository.DepartmentRepository;
import com.psit.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	
	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional
	public DepartmentDTO saveDepartment(DepartmentDTO departmentDto) {
		log.info("DepartmentDTO{}:",departmentDto);
		
		Department department = mapper.map(departmentDto,Department.class);
		mapper.getConfiguration().setAmbiguityIgnored(true);
		Department department2 = deptRepo.save(department);
		department2.set_Active(true);
		department2.setCreated(LocalDateTime.now());
		
		DepartmentDTO departmentDTO2 = mapper.map(department2, DepartmentDTO.class);
		
		return departmentDTO2;
	}

}
