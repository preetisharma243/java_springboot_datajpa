package com.psit.globalException;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.psit.entity.ErrorEntity;
import com.psit.exception.DataNotFoundException;
import com.psit.exception.DuplicateDataFoundException;

import lombok.Getter;
import lombok.Setter;

@RestControllerAdvice
public class EmployeeGlobalExceptionHandler {
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Err> handleValidationExceptions( MethodArgumentNotValidException ex) {
		Err err=new Err();
		err.setRs(ex.getBindingResult());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		// it will print like, 200 OK at rite side, we usually see in postman
      return ResponseEntity.badRequest().body(err);
	}
	
	@ExceptionHandler(DuplicateDataFoundException.class)
	public ResponseEntity<ErrorEntity> handleDuplicateDataFoundException(DuplicateDataFoundException de){
		
		//it print body of json
	ErrorEntity err=new ErrorEntity(de.getMessage(), HttpStatus.BAD_REQUEST.value(),LocalDateTime.now());
		// it will print like, 200 OK at rite side, we usually see in postman
      return ResponseEntity.badRequest().body(err);
	}

	
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<ErrorEntity> handleDataNotFoundException(DataNotFoundException de){
		
		ErrorEntity err=new ErrorEntity(de.getMessage(), HttpStatus.NOT_FOUND.value(),LocalDateTime.now());
		return new ResponseEntity<ErrorEntity>(err,HttpStatus.NOT_FOUND);
		
		
		
}
	
}

@Setter
@Getter
class Err{
	private BindingResult rs;
	private int status;
	
}