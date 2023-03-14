package com.psit.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

@AllArgsConstructor
public class ErrorEntity {
	private String message;
	private int status;
	private LocalDateTime timeStamp;
	

}
