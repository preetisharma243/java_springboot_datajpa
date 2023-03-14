package com.psit.response;

import com.psit.Enum.StatusEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAssesmentResponse {
	private Long id;
	private String firstname;
	private String lastName;
	private String email;
	private StatusEnum status;

}
