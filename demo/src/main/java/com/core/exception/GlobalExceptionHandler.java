package fr.co.mybus.mrn.common.core.exception;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ControllerAdvice
public class GlobalExceptionHandler {

	//private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(Throwable.class)
	public ModelAndView handleExceptions(HttpServletRequest request, Exception ex){
		//logger.info("SQLException Occured:: URL="+request.getRequestURL());
		ModelAndView mav = new ModelAndView("exception");
		System.out.println("Error handler"+request.getRequestURI());
		String requestedUrl = request.getRequestURI();
		mav.setViewName("error/error");
		
		if(requestedUrl != null && requestedUrl.indexOf("/json/") != -1)
		{
			mav.setViewName("redirect:/json/raiseSystemInternalError.do"); 
		}
		
		
		if(ex instanceof MRNNoAuthorityException)
		{
			MRNNoAuthorityException authExcep = (MRNNoAuthorityException)ex; 
			if(requestedUrl != null && requestedUrl.indexOf("/json/") != -1)
			{
				String interOfficeString = "";
				if(authExcep.isInterOffice())
				{
					interOfficeString = "?interOffice=1";
				}
				mav.setViewName("redirect:/json/raiseNoAuthorityError.do"+interOfficeString); 
			}
			else
			{
				if(authExcep.isInterOffice())
				{
					mav.setViewName("error/noAuthorityInterOffice");
				}
				else
				{
					mav.setViewName("error/noAuthority");
				}
				
			}
			
		}
		
		
		
		return mav;
	}
	
	
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="IOException occured")
	@ExceptionHandler(IOException.class)
	public void handleIOException(){
		//logger.error("IOException handler executed");
		//returning 404 error code
	}
}