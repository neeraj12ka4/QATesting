package com.core.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


 
public class MRNInterceptor extends HandlerInterceptorAdapter {
 
	static Logger logger = LogManager.getLogger(MRNInterceptor.class);
	
	@Autowired
	MRNContext mrnContext;
	
	@Autowired
	com.core.message.MRNMessageService mrnMessageService;
	
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
       
//        logger.info("*********************************Request URL::" + request.getRequestURL().toString()
//                + ":: Start Time=" + request.getContextPath()+" ;;;;;;;;;; "+request.getServletPath()+", "+request.getLocalPort()+", "+request.getRemoteHost());
        
        String servletContext = "http://"+request.getServerName()+":"+request.getLocalPort()+request.getContextPath();
        
        
//        logger.info(servletContext);
//        if(!MRNSystemConstant.SYSTEM_URI_LOGIN.equals(request.getServletPath()) && !MRNSystemConstant.SYSTEM_URI_WELCOME.equals(request.getServletPath())
//        		&& !"/json/raiseInvalidSessionError.do".equals(request.getServletPath()) && !"/view/raiseInvalidSessionError.do".equals(request.getServletPath())
//        		&& !"/logout.do".equals(request.getServletPath()) && !"/requestedURLNotSupported.do".equals(request.getServletPath()) && !"/json/raiseSystemInternalError.do".equals(request.getServletPath())
//        		&& !request.getRequestURL().toString().contains(MRNSystemConstant.SYSTEM_URI_ALLOTMENT_REQUEST) && !"/json/raiseNoAuthorityError.do".equals(request.getServletPath()))
//        {
//        	
//        	UserObject userObj = (UserObject) request.getSession().getAttribute("USER");
//        	
//        	if(request.getSession().isNew() || userObj == null)
//        	{
//        		
//        		if(request.getServletPath().indexOf(MRNSystemConstant.SYSTEM_URI_CONTENT_JSON) != -1)
//        		{
//        			response.sendRedirect(request.getContextPath()+"/json/raiseInvalidSessionError.do");
//        		}
//        		else if(request.getServletPath().indexOf(MRNSystemConstant.SYSTEM_URI_CONTENT_VIEW) != -1)
//        		{
//        			response.sendRedirect(request.getContextPath()+"/view/raiseInvalidSessionError.do");
//        		}
//            	else
//            	{
//            		if(!"/main.do".equals(request.getServletPath()))
//            		{
//            			//response.sendRedirect(request.getContextPath()+"/json/raiseInvalidSessionError.do");
//                		response.sendRedirect(request.getContextPath()+"/requestedURLNotSupported.do");
//                		logger.error("Invalid url");
//                		//request.getSession().invalidate();
//            		}
//            		else
//            		{
//            			//if main is called then check if session is expired in main and then display error message with login link 
//            			//else dont show the link to login.
//            			response.sendRedirect(request.getContextPath()+"/view/raiseInvalidSessionError.do");
//            		}
//            		
//            	}
//        		
//        		return false;
//        	}
        	
        	//System.out.println("MRNContext : "+mrnContext);
        	//mrnContext.setScreenCd("MBPPPP");
//        	String screenCd = request.getParameter(MRNSystemConstant.SYSTEM_FORM_FIELD_SCREEN_CD);
//        	
//        	if(StringUtil.isEmpty(screenCd))
//        	{        		
//        		response.sendRedirect(request.getContextPath()+"/view/requestedScreenCdMissing.do");
//        		
//        	} 
        	
        	mrnContext.setScreenCd("Test");
        	
        	
//        }
        
//        String screenCd = request.getParameter(MRNSystemConstant.SYSTEM_FORM_FIELD_SCREEN_CD);
//        mrnContext.setScreenCd(screenCd);
        //request.setAttribute("startTime", startTime);
        //if returned false, we need to make sure 'response' is sent
        return true;
    }
 
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
    	logger.info("*********************************Request URL::" + request.getRequestURL().toString()
                + " Sent to Handler :: Current Time=" + System.currentTimeMillis());
        //we can add attributes in the modelAndView and use that in the view page
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception 
            {
    	
//        long startTime = (Long) request.getAttribute("startTime");
//        logger.info("*********************************Request URL::" + request.getRequestURL().toString()
//                + ":: End Time=" + System.currentTimeMillis());
//        logger.info("*********************************Request URL::" + request.getRequestURL().toString()
//                + ":: Time Taken=" + (System.currentTimeMillis() - startTime));
    }
 
}

