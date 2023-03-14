package com.psit.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "employee")
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "please enter first name")
	@Size(max = 6,min = 4,message = "please enter last name between 4 to 6 character")
	private String firstName;
	
	@NotEmpty(message = "please enter last name")
	@Size(max = 6,min = 4,message = "please enter last name between 4 to 6 character")
	private String lastName;
	
	
	@Pattern(regexp = "@gmail.com",message = "please enter proper email")
	private String email;
	
	@NotNull(message = "please enter mobile no")
	//@Size(max = 10,message = "pleasee enter valid mobile no.")
	private Long mobileNo;
	
	@NotNull(message = "please enter salary")
	private Double salary;
	
	private LocalDateTime created;
	private LocalDateTime updated;
	
	//is_active value should not be null, if we forget to set as true or false
	//for that we take nullable=false
	@Column(name = "isActive", columnDefinition = "boolean default false", nullable = false)
    private boolean is_Active;
	
	
	//in employee table DeptId will be as foreign key
	private Long DeptId;
	
	private Long CompId;

}
