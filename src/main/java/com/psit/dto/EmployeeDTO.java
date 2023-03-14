package com.psit.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class EmployeeDTO {

	//@NotNull(message = "please enter first name")
	//@Size(max = 6, min = 4, message = "please enter last name between 4 to 6 character")
	private String firstName;

	//@NotEmpty(message = "please enter last name")
	//@Size(max = 6, min = 4, message = "please enter last name between 4 to 6 character")
	private String lastName;

	//@Pattern(regexp = "@gmail.com", message = "please enter proper email")
	private String email;

	//@NotNull(message = "please enter mobile no")
	//@Size(max = 10L, message = "pleasee enter valid mobile no.")
	private Long mobileNo;

	//@NotNull(message = "please enter salary")
	private Double salary;
	private Long deptId;
	private Long compId;
}
