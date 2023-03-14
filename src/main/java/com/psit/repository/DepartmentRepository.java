package com.psit.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.psit.constant.QueryConstant;
import com.psit.entity.Department;
import com.psit.projection.UserResponse;



public interface DepartmentRepository extends JpaRepository<Department,Long> {
	
	@Query(value=QueryConstant.FIND_ALL_USERS,nativeQuery = true)
	public List<UserResponse> findAllUser(Pageable paging); 

}
