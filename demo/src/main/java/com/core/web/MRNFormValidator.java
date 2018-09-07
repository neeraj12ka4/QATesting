package com.core.web;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.Validator;

import com.core.message.MRNMessageService;
import com.core.util.StringUtil;




public class MRNFormValidator 
{
	
	/**
	 * @param validator
	 * @param result
	 * @param form
	 * @return
	 */
	public String validateForm(Validator validator, BindingResult result, MRN_Form form, MRNMessageService mrnMessageService)
	{
		 validator.validate(form, result);
		 
		 if (result.hasErrors()) {
		        System.out.println("errors"+result.getErrorCount());
		        System.out.println("errors"+result.getObjectName());
		        
		        String error = "";
		        List allErrors=result.getAllErrors();
		        for(int i=0;i<allErrors.size();i++)
		        {
		        	ObjectError objerr=(ObjectError)allErrors.get(i);
		        	if(mrnMessageService != null)
		        	{
		        		if(!StringUtil.isEmpty(objerr.getCode()))
		        		{
		        			String message = mrnMessageService.getMessage(objerr.getCode());
		        			if(!StringUtil.isEmpty(message))
		        			{
		        				error+=message+"<br>";
		        			}
		        			else
		        			{
		        				error+=objerr.getDefaultMessage()+"<br>";
		        			}
		        			
		        		}
		        		else
		        		{
		        			error+=objerr.getDefaultMessage()+"<br>";
		        		}
		        		
		        	}
		        	else
		        	{
		        		error+=objerr.getDefaultMessage()+"<br>";
		        	}
		        			        	
		        }
		        
		       
		        return error;
		       
		    }
		 
		return null;
	}

}
