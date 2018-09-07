package fr.co.mybus.mrn.common.core.db.exception;

import fr.co.mybus.mrn.common.core.exception.MRNRuntimeException;

public class MRNDbException extends MRNRuntimeException 
{
//	String displayMessage;
	
	/**
	 * @param message
	 */
	public MRNDbException(String message)
	{
		super(message);
	}
	
	
	
	/**
	 * @param message
	 * @param displayMessage
	 */
	public MRNDbException(String message, String messageCode)
	{
		super(message);
		this.messageCode = messageCode;
	}
	


//	public String getDisplayMessage() {
//		return displayMessage;
//	}
//
//
//	public void setDisplayMessage(String displayMessage) {
//		this.displayMessage = displayMessage;
//	}

}
