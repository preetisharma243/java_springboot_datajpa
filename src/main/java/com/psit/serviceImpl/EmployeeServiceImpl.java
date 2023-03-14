package com.psit.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psit.constant.AppConstant;
import com.psit.dto.EmployeeDTO;
import com.psit.entity.Employee;
import com.psit.exception.DataNotFoundException;
import com.psit.exception.DuplicateDataFoundException;
import com.psit.repository.EmployeeRepository;
import com.psit.response.EmployeeResponse;
import com.psit.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Autowired
	private EmployeeRepository empRepository;

	@Autowired
	private ModelMapper mapper;

	@Override
	@Transactional
	public EmployeeResponse saveEmployee(EmployeeDTO employeeDto) {

		log.info("EmployeeDTO{}:", employeeDto);
		// Employee findEmpoyeeByEmailId =
		// empRepository.findEmpoyeeByEmailId(employeeDto.getEmail();

		if (empRepository.findEmpoyeeByEmailId(employeeDto.getEmail()) != null) {

			throw new DuplicateDataFoundException(AppConstant.EMPLOYEE_EXIST);
		}

		mapper.getConfiguration().setAmbiguityIgnored(true);
		Employee employee = mapper.map(employeeDto, Employee.class);
		 log.info("Employee ENTITY::"+employee);
		employee.set_Active(true);
		employee.setCreated(LocalDateTime.now());

		Employee employee2 = empRepository.save(employee);
		 log.info("Employee::"+employee2);

		 EmployeeResponse employeeResponse = mapper.map(employee2, EmployeeResponse.class);
		 
		 log.info("EmployeeResponse::"+employeeResponse);

		return employeeResponse;
	}

	@Override
	public EmployeeResponse updateEmployee(Long id, EmployeeDTO employeeDto) {
		log.info("employee id:"+id+" employeeDTO:"+employeeDto);

		Employee employee = empRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException(AppConstant.DATA_NOT_AVAILABLE));
		
		log.info("employee obj already saved in db:"+employee);
		
		//here email id is not edited by user,and we are checking that comming email id(from employeeDto)is same with existing one(employee obj)
		if (employee.getEmail().equalsIgnoreCase(employeeDto.getEmail())) {
			employee.setId(id);
			employee.setFirstName(employeeDto.getFirstName());
			employee.setEmail(employeeDto.getEmail());
			employee.setLastName(employeeDto.getLastName());
			employee.setMobileNo(employeeDto.getMobileNo());
			employee.setCompId(employeeDto.getCompId());
			employee.setDeptId(employeeDto.getDeptId());
			employee.setUpdated(LocalDateTime.now());

			Employee employee2 = empRepository.save(employee);
			
			log.info(" updated data in db:"+employee2);

			 EmployeeResponse employeeResponse = mapper.map(employee2, EmployeeResponse.class);

			return employeeResponse;
		}
		
		
		//here email id is edited bye user, and we are cheking that email id already exist in db or not
		else if(empRepository.findEmpoyeeByEmailId(employeeDto.getEmail()) != null) {
			
			throw new DuplicateDataFoundException(AppConstant.EMPLOYEE_EXIST);
		}
		else {
			
			employee.setId(id);
			employee.setFirstName(employeeDto.getFirstName());
			employee.setEmail(employeeDto.getEmail());
			employee.setLastName(employeeDto.getLastName());
			employee.setMobileNo(employeeDto.getMobileNo());
			employee.setCompId(employeeDto.getCompId());
			employee.setDeptId(employeeDto.getDeptId());
			employee.setUpdated(LocalDateTime.now());

			Employee employee2 = empRepository.save(employee);

			 EmployeeResponse employeeResponse = mapper.map(employee2, EmployeeResponse.class);

			return employeeResponse;
			
		}

	}

	@Override
	public Map<String, Object> searchEmployee(String keyword, Integer pageNo, Integer pageSize) {
		
	
		
		Pageable paging=null;
		/*
		 * if(direction.equalsIgnoreCase("ASC")){ paging=PageRequest.of(pageNo-1,
		 * pageSize, Sort.Direction.ASC);
		 * 
		 * }
		 * 
		 * else { paging=PageRequest.of(pageNo-1, pageSize, Sort.Direction.DESC); }
		 */
		List<EmployeeResponse> searchResult = new ArrayList<>();

		Page<Employee> pageRequest = empRepository.searchEmployee(keyword, paging);

		List<Employee> searchResponse = pageRequest.getContent();
		         
		for (Employee emp : searchResponse) {
			EmployeeResponse empResp=new EmployeeResponse();
			empResp.setCompId(emp.getCompId());
			empResp.setDeptId(emp.getDeptId());
			empResp.setEmail(emp.getEmail());
			empResp.setFirstName(emp.getFirstName());
			empResp.setLastName(emp.getLastName());
			empResp.setMobileNo(emp.getMobileNo());
			empResp.setSalary(emp.getSalary());
			searchResult.add(empResp);	
		}
		if (searchResult.isEmpty()) {
			throw new DataNotFoundException(AppConstant.DATA_NOT_AVAILABLE);
		}

		Map<String, Object> map = new HashMap<>();
		map.put("EmployeeResult", searchResult);
		map.put("totalItems", pageRequest.getTotalElements());
		return map;

	}

}
