package com.shopping.exception;

public class CustomerDataInvalidException extends RuntimeException {

	private String exceptionmsg;

	public CustomerDataInvalidException(String exceptionmsg) {
		super();
		this.exceptionmsg = exceptionmsg;
	}

	public CustomerDataInvalidException() {
		super();
	}

	public String getExceptionmsg() {
		return exceptionmsg;
	}

	public void setExceptionmsg(String exceptionmsg) {
		this.exceptionmsg = exceptionmsg;
	}

	@Override
	public String toString() {
		return "customerDataInvalidException [exceptionmsg=" + exceptionmsg + "]";
	}
	
}
