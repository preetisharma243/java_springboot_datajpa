package com.psit.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.psit.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
	
	
	//in hql we use "e" in place of star 
	//@Query(" select e from  Employee e where e.email=:email and e.is_Active)
	//e.email is entity class variable, and :emal is named parameter that will capture value passed from front end/postman
	@Query(" from  Employee e where e.email=:email and e.is_Active=true")
	Employee findEmpoyeeByEmailId(@Param("email")String email);
	
	
	@Query("from Employee e where e.id=:id and e.is_Active=true")
	 Optional<Employee> findById(Long id);
	
	
	
	
    // http://localhost:9004/emp/searchEmp?keyword=agra
	//"select e from employe e where e.firstName like %:keyword% or e.lastName like %:keyword or e.email like %:keyword% or e.mobileNo like %:keyword or e.salary like %:keyword% and e.is_active=true ";
	@Query("SELECT e FROM Employee e WHERE CONCAT(e.firstName,e.lastName,e.email,e.mobileNo,e.salary) LIKE %:keyword% and e.is_Active=true")
    Page<Employee> searchEmployee(String keyword, Pageable paging);
	 
		

}
