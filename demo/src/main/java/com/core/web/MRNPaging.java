package com.core.web;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import fr.co.mybus.mrn.common.constants.ApConstants;
import fr.co.mybus.mrn.common.util.StringUtil;


public class MRNPaging 
{
	int startIndex;
	
	int endIndex;
	
	/**
	 * @param totalcount
	 * @param page
	 * @param currentPage
	 * @param modelAndView
	 */
	public void pagingCalculation(int totalcount, int page, ModelAndView modelAndView, String methodPostfix,boolean shortButton){
//		System.out.println("Search start page :"+pl0201aForm.getPage()+"total:"+pl0201aForm.getTotalCount());
		
		int totalPage=0;
		int startIndex=1;
		int endIndex=ApConstants.SEARCH_MAX_RECORDS;
		if(page==0 && totalcount > 0){
		   if(totalcount>ApConstants.SEARCH_MAX_RECORDS){
				totalPage=(int)Math.round((float)totalcount/ApConstants.SEARCH_MAX_RECORDS+0.49);
				modelAndView.addObject("totalRecord", totalcount);
				startIndex=1;
				endIndex=ApConstants.SEARCH_MAX_RECORDS;
				
				modelAndView.addObject("paging", Paging(page, totalPage, methodPostfix,shortButton));	
			 }else{
				 startIndex=1; 
				 endIndex=totalcount;
			 }
		     modelAndView.addObject("totalRecord", totalcount);
			 modelAndView.addObject("startIndex",startIndex);
			 modelAndView.addObject("endIndex",endIndex);
		
		}
		else if(page>0&& totalcount>0){
			totalPage=(int)Math.round((float)totalcount/ApConstants.SEARCH_MAX_RECORDS+0.49);
			modelAndView.addObject("totalRecord", totalcount);
			startIndex=((page-1)*ApConstants.SEARCH_MAX_RECORDS)+1;
			if(page==totalPage)
				endIndex=totalcount;
			else
				endIndex=page*ApConstants.SEARCH_MAX_RECORDS;
			
			modelAndView.addObject("paging", Paging(page, totalPage, methodPostfix,shortButton));
			modelAndView.addObject("totalRecord", totalcount);
		    modelAndView.addObject("startIndex",startIndex);
		     modelAndView.addObject("endIndex",endIndex);
			
		}
		
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	
	
	
	
	
	/**
	 * @param currentPage
	 * @param totalPage
	 * @return
	 */
	public String Paging(int currentPage, int totalPage, String methodPostfix, boolean shortButton){
		String pageString="";
		if(StringUtil.isEmpty(methodPostfix))
		{
			methodPostfix = "";			
		}
		
		if(shortButton)
		{
			if(currentPage==0||currentPage==1){
				pageString="<span class=\"Btn_small_text\"><b>|<</b></span> "+
							"<span class=\"Btn_small_text\"><b><<</b></span> "+
							"<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('2');\"><b>>></b></a></span> "+
							"<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+totalPage+"');\"><b>>|</b></a></span> ";
			}else if(currentPage==totalPage){	
				pageString="<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('1');\"><b>|<</b></a></span> "+
							"<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+(currentPage-1)+"');\"><b><<</b></a></span> "+
							"<span class=\"Btn_small_text\"><b>>></b></span> "+
							"<span class=\"Btn_small_text\"><b>>|</b></span> ";
			}else if(currentPage>1&&currentPage<totalPage){
				pageString="<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('1');\"><b>|<</b></a></span> "+
				           "<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+(currentPage-1)+"');\"><b><<</b></a></span> "+
				           "<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+(currentPage+1)+"');\"><b>>></b></a></span> "+
						   "<span class=\"Btn_small_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+totalPage+"');\"><b>>|</b></a></span> ";
			}
		}
		else
		{
			if(currentPage==0||currentPage==1){
				pageString="<span class=\"Btn_text\"><b>(|<) First</b></span> "+
							"<span class=\"Btn_text\"><b>(<<) Prev</b></span> "+
							"<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('2');\"><b>Next (>>)</b></a></span> "+
							"<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+totalPage+"');\"><b>Last (>|)</b></a></span> ";
			}else if(currentPage==totalPage){	
				pageString="<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('1');\"><b>(|<) First</b></a></span> "+
							"<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+(currentPage-1)+"');\"><b>(<<) Prev</b></a></span> "+
							"<span class=\"Btn_text\"><b>Next (>>)</b></span> "+
							"<span class=\"Btn_text\"><b>Last (>|)</b></span> ";
			}else if(currentPage>1&&currentPage<totalPage){
				pageString="<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('1');\"><b>(|<) First</b></a></span> "+
				           "<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+(currentPage-1)+"');\"><b>(<<) Prev</b></a></span> "+
				           "<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+(currentPage+1)+"');\"><b>Next (>>)</b></a></span> "+
						   "<span class=\"Btn_text\"> <a href=\"javascript:void(0)\" onclick=\"javascript:doPaging"+methodPostfix+"('"+totalPage+"');\"><b>Last (>|)</b></a></span> ";
			}
		}
		
		return pageString;
	}



	public int getStartIndex() {
		return startIndex;
	}



	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}



	public int getEndIndex() {
		return endIndex;
	}



	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

}
