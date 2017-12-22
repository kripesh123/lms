package com.texas.librarymanagementsystem.controller.exception;

public class CustomerNotFoundException  extends RuntimeException{

	 private static final long serialVersionUID = 4088649120307193208L;

	    public CustomerNotFoundException() {
	        super();
	    }

	    public CustomerNotFoundException(final String message, final Throwable cause) {
	        super(message, cause);
	    }

	    public CustomerNotFoundException(final String message) {
	        super(message);
	    }

	    public CustomerNotFoundException(final Throwable cause) {
	        super(cause);
	    }
}
