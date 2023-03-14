package com.psit.service;

import java.util.List;

import com.psit.response.UserAssesmentResponse;

public interface UserService {
	public List<UserAssesmentResponse> findAllUser(Integer pageNo, Integer pageSize, String direction, String sortBy);

}
