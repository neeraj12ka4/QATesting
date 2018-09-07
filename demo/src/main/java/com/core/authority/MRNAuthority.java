package com.core.authority;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.co.mybus.mrn.common.constants.ApConstants;
import fr.co.mybus.mrn.common.constants.DbCodeConstant;
import fr.co.mybus.mrn.common.core.exception.MRNErrorException;
import fr.co.mybus.mrn.common.core.exception.MRNNoAuthorityException;
import fr.co.mybus.mrn.common.core.exception.MRNRuntimeException;
import fr.co.mybus.mrn.common.core.web.MRNContext;
import fr.co.mybus.mrn.common.dbtables.MScreenAuthority;
import fr.co.mybus.mrn.common.login.dao.UserObject;
import fr.co.mybus.mrn.common.util.StringUtil;

/**
 * @author NSC
 *
 */
public class MRNAuthority 
{
	
	/**
	 * Config
	 */
	MScreenAuthority mScreenAuthority = null;
	
	/**
	 * Config
	 */
	MRNContext mrnContext;
	
	
//	public int checkAuthority()throws MRNNoAuthorityException
//	{
//		return checkAuthority(null);
//	}
	
	/**
	 * @param screenCd
	 * @param roleCd
	 * @return
	 * @throws MRNNoAuthorityException
	 */
	public boolean checkAuthority(String screenCd, int operationCd, String officeCd)throws MRNNoAuthorityException
	{
		if(screenCd == null)
		{
			screenCd = mrnContext.getScreenCd();
		}
		
		UserObject user = mrnContext.getUserObject();
		List roles = user.getRoles();
		String userOfficeCd = user.getOfficeCd();
		
		if(StringUtil.isEmpty(officeCd))
		{
			throw new MRNRuntimeException("Office code is missing for authority");
		}
		
		/**
		 * 
		 * if operation cd is missing then check for all operation authority only
		 * 
		 * if office cd is missing then raise error 
		 * 
		 * 
		 * 
		 * 
		 */
		int authorityCd = DbCodeConstant.DB_AUTHORITY_CD_NO_AUTHORITY;
		
		if(ApConstants.APPLICATION_OPERATION_TYPE_VIEW == operationCd)
		{
			authorityCd = DbCodeConstant.DB_AUTHORITY_CD_VIEW_AUTHORITY;
		}
		else if(ApConstants.APPLICATION_OPERATION_TYPE_EDIT == operationCd)
		{
			authorityCd = DbCodeConstant.DB_AUTHORITY_CD_EDIT_AUTHORITY;
		}
		else if(ApConstants.APPLICATION_OPERATION_TYPE_CREATE == operationCd)
		{
			authorityCd = DbCodeConstant.DB_AUTHORITY_CD_CREATE_AUTHORITY;
		}
		
		int interOfficeAuthority = DbCodeConstant.DB_INTER_OFFICE_NO_AUTHORITY;
		
		boolean interOffice = false;
		
		if(!userOfficeCd.equals(officeCd))
		{
			interOfficeAuthority = DbCodeConstant.DB_INTER_OFFICE_YES_AUTHORITY;
			interOffice = true;
		}
		
		int authority = 0;
		
		Iterator roleItr = roles.iterator();
		
		while(roleItr.hasNext())
		{
			String roleCd = (String)roleItr.next();
			List authList = mScreenAuthority.getScreenAuthority(roleCd, screenCd, authorityCd, interOfficeAuthority);
			
			Iterator itr = authList.iterator();
			
			while(itr.hasNext())
			{
				MScreenAuthority rec = (MScreenAuthority)itr.next();
				int assignedAuth = Integer.parseInt(rec.getAuthorityCd());
				
				if(assignedAuth == authorityCd || assignedAuth == DbCodeConstant.DB_AUTHORITY_CD_ALL_AUTHORITY)
				{
					authority = assignedAuth;
				}
				
			}
		}
		
		
		if(DbCodeConstant.DB_AUTHORITY_CD_NO_AUTHORITY == authority)
		{
			throw new MRNNoAuthorityException("Screen "+screenCd+" has no authority", interOffice);
		}
		
		return true;
	}

	public void setMScreenAuthority(MScreenAuthority screenAuthority) {
		mScreenAuthority = screenAuthority;
	}

	public void setMrnContext(MRNContext mrnContext) {
		this.mrnContext = mrnContext;
	}
	

}
