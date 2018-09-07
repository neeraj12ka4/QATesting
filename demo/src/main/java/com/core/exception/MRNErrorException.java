package fr.co.mybus.mrn.common.core.exception;

public class MRNErrorException extends Exception 
{
	String displayMessage;
	String code;
	/**
	 * @param message
	 */
	public MRNErrorException(String message)
	{
		super(message);
		
	}
	
	
	/**
	 * @param message
	 * @param displayMessage
	 */
	public MRNErrorException(String message, String displayMessage)
	{
		super(message);
		this.displayMessage = displayMessage;
	}
	
	public MRNErrorException(String message, String displayMessage, String code)
	{
		super(message);
		this.displayMessage = displayMessage;
		this.code = code;
	}


	public String getDisplayMessage() {
		return displayMessage;
	}


	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}

}
