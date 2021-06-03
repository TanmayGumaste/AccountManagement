package com.springjpa.car.accountmanagement.model;

import java.util.Date;

import lombok.Data;
@Data
public class ErrorMessage {

	private Date timeStamp;
	private String message;
	private String errorCode;
	
	public ErrorMessage() {}
	public ErrorMessage(Date timeStamp,String message,String errorCode) {
		
		this.timeStamp=timeStamp;
		this.message=message;
		this.errorCode=errorCode;
	}

	
}
