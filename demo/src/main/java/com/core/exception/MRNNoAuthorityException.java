package fr.co.mybus.mrn.common.core.exception;

/**
 * @author neerajsi
 *
 */
public class MRNNoAuthorityException extends RuntimeException 
{
	String displayMessage;
	
	String code;
	
	boolean interOffice;
	/**
	 * @param message
	 */
	public MRNNoAuthorityException(String message)
	{
		super(message);
		
	}
	
	
	/**
	 * @param message
	 */
	public MRNNoAuthorityException(String message, boolean interOffice)
	{
		super(message);
		
		this.interOffice = interOffice;
		
	}
	
	
	/**
	 * @param message
	 * @param displayMessage
	 */
	public MRNNoAuthorityException(String message, String displayMessage)
	{
		super(message);
		this.displayMessage = displayMessage;
	}


	public String getDisplayMessage() {
		return displayMessage;
	}


	public void setDisplayMessage(String displayMessage) {
		this.displayMessage = displayMessage;
	}


	public boolean isInterOffice() {
		return interOffice;
	}

}
