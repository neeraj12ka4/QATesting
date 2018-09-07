package com.core.message;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;



/**
 * @author NSC
 *
 */
public class MRNMessageService implements MessageSourceAware
{
	List errorMessage;
	
	List warningMessage;
	
	List infoMessage;
	
	
	private MessageSource messageSource;
	
	/**
	 * 
	 */
	public MRNMessageService()
	{
		errorMessage = new ArrayList();
		warningMessage = new ArrayList();
		infoMessage = new ArrayList();
	}
	
	public void printMessage()
	{
		String errorMessages = "";
		Iterator itr = errorMessage.iterator();
		while(itr.hasNext())
		{
			MRNMessage message = (MRNMessage)itr.next();
			String messageStr = messageSource.getMessage(message.getMessageCode(),message.getParams(), Locale.US);
			errorMessages += message.getMessageCode()+" : "+messageStr + "<br>";
		}


    	System.out.println(errorMessages);


	}
	
	
	/**
	 * @return
	 */
	public String getErrorMessage()
	{
		String errorMessages = "";
		Iterator itr = errorMessage.iterator();
		while(itr.hasNext())
		{
			MRNMessage message = (MRNMessage)itr.next();
			if("MSG10100".equals(message.getMessageCode()))
			{
				continue;
			}
			String messageStr = messageSource.getMessage(message.getMessageCode(),message.getParams(), Locale.US);
			errorMessages += message.getMessageCode()+" : "+messageStr + "<br>";
		}
		
		if(!com.core.util.StringUtil.isEmpty(errorMessages))
		{
			String messageStr = "MSG10100 : "+messageSource.getMessage("MSG10100",null, Locale.US);
			
	    	return messageStr+"<br>"+errorMessages;
		}
		
		return errorMessages;

	}
	
	/**
	 * @param message1
	 * @param message2
	 * @return
	 */
	public String appendMessage(String message1, String message2)
	{
		
			return message1+ "<br>" +message2;
		
	}
	
	
	/**
	 * @return
	 */
	public String getWarningMessage()
	{
		String warningMessages = "";
		Iterator itr = warningMessage.iterator();
		while(itr.hasNext())
		{
			MRNMessage message = (MRNMessage)itr.next();
			String messageStr = messageSource.getMessage(message.getMessageCode(),message.getParams(), Locale.US);
			warningMessages += message.getMessageCode()+" : "+messageStr + "<br>";
		}


    	return warningMessages;


	}
	
	/**
	 * @return
	 */
	public String getInfoMessage()
	{
		String infoMessages = "";
		Iterator itr = infoMessage.iterator();
		while(itr.hasNext())
		{
			MRNMessage message = (MRNMessage)itr.next();
			
			
			
			String messageStr = messageSource.getMessage(message.getMessageCode(),message.getParams(), Locale.US);
			infoMessages += message.getMessageCode()+" : "+messageStr + "<br>";
		}

		
    	return infoMessages;


	}

	/**
	 * @param messageCode
	 * @return
	 */
	public String getMessage(String messageCode)
	{
		String messageStr = messageCode+" : "+messageSource.getMessage(messageCode,null, Locale.US);

    	return messageStr;

	}
	
	
	/**
	 * @param messageCode
	 * @return
	 */
	public String getErrorMessage(String messageCode)
	{
		String messageStr = "MSG10100 : "+messageSource.getMessage("MSG10100",null, Locale.US);
		messageStr += "<br>"+messageCode+" : "+messageSource.getMessage(messageCode,null, Locale.US);

    	return messageStr;

	}
	
	
	
	/**
	 * @param messageCode
	 * @return
	 */
	public String getMessageWithNL(String messageCode)
	{
		String messageStr = messageCode+" : "+messageSource.getMessage(messageCode,null, Locale.US)+"<br>";

    	return messageStr;

	}

	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}
	
	
	/**
	 * @param code
	 * @param param
	 */
	public void addError(String code, Object[] param)
	{
		MRNMessage mrnMessage = new MRNMessage(code, param);
		
		errorMessage.add(mrnMessage);
	}
	
	/**
	 * @param code
	 */
	public void addError(String code)
	{
		MRNMessage mrnMessage = new MRNMessage(code, null);
		
		errorMessage.add(mrnMessage);
	}
	
	/**
	 * @param code
	 */
	public void addMasterError(String code)
	{
		MRNMessage mrnMessage = new MRNMessage(code, null);
		
		errorMessage.add(0,mrnMessage);
	}
	
	
	/**
	 * @param code
	 * @param param
	 */
	public void addWarning(String code, Object[] param)
	{
		MRNMessage mrnMessage = new MRNMessage(code, param);
		
		warningMessage.add(mrnMessage);
	}
	
	
	/**
	 * @param code
	 */
	public void addWarning(String code)
	{
		MRNMessage mrnMessage = new MRNMessage(code, null);
		
		warningMessage.add(mrnMessage);
	}
	
	/**
	 * @param code
	 * @param param
	 */
	public void addInfo(String code, Object[] param)
	{
		MRNMessage mrnMessage = new MRNMessage(code, param);
		
		infoMessage.add(mrnMessage);
	}
	
	/**
	 * @param code
	 */
	public void addInfo(String code)
	{
		MRNMessage mrnMessage = new MRNMessage(code, null);
		
		infoMessage.add(mrnMessage);
	}
	
	/**
	 * @param code
	 */
	public void addMasterInfo(String code)
	{
		MRNMessage mrnMessage = new MRNMessage(code, null);
		
		infoMessage.add(0,mrnMessage);
	}
	
	
	/**
	 * @return
	 */
	public boolean isError()
	{
		if(errorMessage.size() > 0)
		{
			return true;
		}
		
		return false;
	}
	
	

}
