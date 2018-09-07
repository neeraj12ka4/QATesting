package com.core.message;

public class MRNMessage 
{
	
	String messageCode;
	
	Object[] params;


	public MRNMessage(String messageCode, Object[] params) {
		super();
		this.messageCode = messageCode;
		this.params = params;
	}


	public String getMessageCode() {
		return messageCode;
	}


	public Object[] getParams() {
		return params;
	}
	
	
	

}
