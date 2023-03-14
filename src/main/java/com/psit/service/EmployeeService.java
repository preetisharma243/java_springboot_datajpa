package com.psit.service;

import java.util.Map;

import com.psit.dto.EmployeeDTO;
import com.psit.response.EmployeeResponse;

public interface EmployeeService {
	
	public EmployeeResponse saveEmployee(EmployeeDTO employeeDto);
	public EmployeeResponse updateEmployee(Long id,EmployeeDTO employeeDto);
	public Map<String, Object> searchEmployee(String keyword, Integer pageNo, Integer pageSize);

}
