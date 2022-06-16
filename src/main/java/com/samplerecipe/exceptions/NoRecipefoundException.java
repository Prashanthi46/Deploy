package com.samplerecipe.exceptions;

public class NoRecipefoundException  extends Exception{
	private static final long serialVersionUID = 1L;
	public NoRecipefoundException() {
	super();
	}

	 public NoRecipefoundException(String message) {
	super(message);
	}
	public NoRecipefoundException(String message, Throwable cause) {
	super(message, cause);
	}
	public NoRecipefoundException(Throwable cause) {
	super(cause);
	}


}
