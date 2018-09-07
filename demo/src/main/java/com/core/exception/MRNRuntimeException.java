package fr.co.mybus.mrn.common.core.exception;

public class MRNRuntimeException extends RuntimeException 
{
	/**
	 * message code
	 */
	public String messageCode;
	
	public MRNRuntimeException(String message)
	{
		super(message);
	}

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

}
