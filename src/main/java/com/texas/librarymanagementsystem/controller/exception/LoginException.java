package com.texas.librarymanagementsystem.controller.exception;

public class LoginException extends RuntimeException {

	private static final long serialVersionUID = 5286625345097914381L;

	public LoginException() {
		super();
	}

	public LoginException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public LoginException(final String message) {
		super(message);
	}

	public LoginException(final Throwable cause) {
		super(cause);
	}
}
