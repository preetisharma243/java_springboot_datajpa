package com.psit.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String companyName;
	private String companyAdd;
	
	private LocalDateTime created;
	private LocalDateTime updated;
	
	//is_active value should not be null, if we forget to set as true or false
	//for that we take nullable=false
	@Column(name = "isActive", columnDefinition = "boolean default false", nullable = false)
    private boolean is_Active;
	

}
