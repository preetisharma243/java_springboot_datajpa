package com.psit.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.psit.Enum.StatusEnum;
import com.psit.constant.AppConstant;
import com.psit.exception.DataNotFoundException;
import com.psit.projection.UserResponse;
import com.psit.repository.DepartmentRepository;
import com.psit.response.UserAssesmentResponse;
import com.psit.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public List<UserAssesmentResponse> findAllUser(Integer pageNo, Integer pageSize, String direction, String sortBy) {
		Pageable paging=null;
		
		if(direction.equalsIgnoreCase("ASC")) {
			paging=PageRequest.of(pageNo-1, pageSize, Sort.Direction.ASC, sortBy);
		}
		else {
			paging=PageRequest.of(pageNo-1, pageSize, Sort.Direction.DESC, sortBy);
		}
		
		List<UserResponse> allUser = deptRepo.findAllUser(paging);
		
		if(allUser.isEmpty()) {
			throw new DataNotFoundException(AppConstant.DATA_NOT_AVAILABLE);
		}
		
		//because we have to add multiple object comming from db and we have to add thm in list type of userAssesmentResponse
		List<UserAssesmentResponse> list=new ArrayList<>();
		
		for(UserResponse userResponse :allUser) {
			if(userResponse.getReport_generated()==true) {
				UserAssesmentResponse userAssesment= new UserAssesmentResponse();
				userAssesment.setId(userResponse.getId());
				userAssesment.setFirstname(userResponse.getFirst_name());
				userAssesment.setLastName(userResponse.getLast_name());
				userAssesment.setEmail(userResponse.getEmail());
				userAssesment.setStatus(StatusEnum.COMPLETED);
				
				list.add(userAssesment);
			}
			
			else
			{
				UserAssesmentResponse userAssesment= new UserAssesmentResponse();
				userAssesment.setId(userResponse.getId());
				userAssesment.setFirstname(userResponse.getFirst_name());
				userAssesment.setLastName(userResponse.getLast_name());
				userAssesment.setEmail(userResponse.getEmail());
				userAssesment.setStatus(StatusEnum.INCOMPLETED);
				
				list.add(userAssesment);
			}
				
			
			}
			
		
	return list;
	}

}
