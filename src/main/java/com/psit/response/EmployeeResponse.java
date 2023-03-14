package com.psit.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeResponse {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Long mobileNo;
	private Double salary;
    private Long deptId;
    private Long compId;

}
