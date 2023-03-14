package com.psit.exception;

public class DuplicateDataFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateDataFoundException() {

	}

	public DuplicateDataFoundException(String msg) {

		super(msg);
	}

}
