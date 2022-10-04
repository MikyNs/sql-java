package com.example.dbutil;

public class GenericDatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public GenericDatabaseException() {
	}

	public GenericDatabaseException(String message) {
		super(message);
	}

	public GenericDatabaseException(Throwable cause) {
		super(cause);
	}

	public GenericDatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public GenericDatabaseException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}