package com.psit;
	/*package com.ashokit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ashokit.dto.EmployeeDTO;
import com.ashokit.entity.Employee;
import com.ashokit.repository.EmployeeRepository;
import com.ashokit.response.EmployeeResponse;
import com.ashokit.serviceImpl.EmployeeServiceImpl;

/*@MockitoSettings(strictness = Strictness.LENIENT)//it stricktly follow the mockito settings
@ExtendWith(MockitoExtension.class)//it tells that employeeserviceTest is running in mockito envioronment so we can use mockito functionality
class EmployeeServiceTest {
	
	
	
	
	
	 EmployeeServiceTest(){}
	
	
	@Mock
	ModelMapper mapper=new ModelMapper();
	
	
	@Mock
	EmployeeRepository empRepository;
	
	@InjectMocks
	EmployeeServiceImpl empService;
	
	
	
	
	
	EmployeeDTO employeeDto= new EmployeeDTO();
	EmployeeResponse employeeResponse=new EmployeeResponse();
	Employee emp=new Employee();
	Configuration configurationMock = null;
	EmployeeServiceImpl service=null;
	
	
	
	@BeforeEach
	public void setUp() {
		service=Mockito.mock(EmployeeServiceImpl.class);
		MockitoAnnotations.initMocks(this);
    employeeDto.setCompId(1l);
	employeeDto.setDeptId(1l);
	employeeDto.setEmail("preeti@gmail.com");
	employeeDto.setFirstName("preeti");
	employeeDto.setLastName("sharma");
	employeeDto.setMobileNo(123456789l);
	employeeDto.setSalary(1223445.00);
	
	
	employeeResponse.setCompId(1l);
	employeeResponse.setDeptId(1l);
	employeeResponse.setEmail("preeti@gmail.com");
	employeeResponse.setFirstName("preeti");
	employeeResponse.setLastName("sharma");
	employeeResponse.setMobileNo(123456789l);
	employeeResponse.setSalary(1223445.00);
	
	/*
	 * emp.setId(1l); emp.setCompId(1l); emp.setDeptId(1l);
	 * emp.setEmail("preeti@gmail.com"); emp.setFirstName("preeti");
	 * emp.setLastName("sharma"); emp.setMobileNo(123456789l);
	 * emp.setSalary(1223445.00);
	 */
/*
/	configurationMock = mock(Configuration.class);
	
	
	}
	
	
	@Test
	@DisplayName("Postive Test Case For Saving Employee Record")
	public void testSaveEmployee() {
		ModelMapper map=new ModelMapper();
		map.getConfiguration().setAmbiguityIgnored(true);
		Employee map2 = map.map(employeeDto, Employee.class);
		System.out.println("map2..."+map2);
		Mockito.when(configurationMock.setAmbiguityIgnored(true)).thenReturn(configurationMock);
		when(mapper.getConfiguration()).thenReturn(configurationMock);
		when(mapper.map(employeeDto, Employee.class)).thenReturn(emp);
		when(empRepository.save(emp)).thenReturn(emp); 
		when(mapper.map(emp, EmployeeResponse.class)).thenReturn(employeeResponse);
		EmployeeResponse empResponse = service.saveEmployee(employeeDto);
		
	
		assertEquals(empResponse, employeeResponse);
		
		System.out.println("Emp.."+emp);
	
		
	
	
		
		
	}


	
	
	

}*/
