package com.pubapp.util;


import com.pubapp.model.NewUser;
import com.pubapp.model.PubRequest;

public class pubRequestValidator {
	
	
public void handlerexception(PubRequest user) throws PubException
{
	String acction=user.getAction();
if(acction==null)
{
	throw new PubException(PubExceptionConstants.ACTION_NOT_FOUND);
}
}
	
	
public void usermissingexception(PubRequest user)throws PubException
{
	if(user.getNewuser()==null)
	{
		throw new PubException(PubExceptionConstants.NEW_USER_NOT_FOUND);
	}
	else if(user.getNewuser().getUemail()==null)
	{
		throw new PubException(PubExceptionConstants.EMAIL_NOT_FOUND);
	}
	else if (user.getNewuser().getUpassword()==null) {
		
		throw new PubException(PubExceptionConstants.UPASSWORD_NOT_FOUND);
	}
	
}
public void keyvalueMissingException(PubRequest user) throws PubException
{
	if(user.getAppid()==0)
	{
		throw new PubException(PubExceptionConstants.APPID_NOT_FOUND);
		
	}
	else if (user.getUserid()==null) {
		throw new PubException(PubExceptionConstants.USER_ID_NOT_FOUND);
		
	}
	else if (user.getKeyvalue()==null) {
		throw new PubException(PubExceptionConstants.KEY_VALUE_NOT_FOUND);
		
	}
}

public void updateApplicationMissingException(PubRequest user) throws PubException
{
	 if (user.getUserid()==null) {
		throw new PubException(PubExceptionConstants.USER_ID_NOT_FOUND);
		
	}
	 else if (user.getApplicationtab()==null) {
		 throw new PubException(PubExceptionConstants.APPLICATION_TAB_NOT_FOUND);
		
	}
	
}

public void getaApplicationByIdMissingException(PubRequest user) throws PubException
{
	 if (user.getUserid()==null) {
			throw new PubException(PubExceptionConstants.USER_ID_NOT_FOUND);
			
		}
	 if(user.getAppid()==0)
		{
			throw new PubException(PubExceptionConstants.APPID_NOT_FOUND);
			
		}
	 
	
}
public void getKeyValuePairMissingException(PubRequest user) throws PubException
{
	 if (user.getUserid()==null) {
			throw new PubException(PubExceptionConstants.USER_ID_NOT_FOUND);
			
		}
	 if(user.getAppid()==0)
		{
			throw new PubException(PubExceptionConstants.APPID_NOT_FOUND);
			
		}
}
public void getValueMissingException(PubRequest user) throws PubException
{
	 if (user.getUserid()==null) {
			throw new PubException(PubExceptionConstants.USER_ID_NOT_FOUND);
			
		}
	 if(user.getAppid()==0)
		{
			throw new PubException(PubExceptionConstants.APPID_NOT_FOUND);
			
		}
	 
	 if(user.getKey()==null)
	 {
		 throw new PubException(PubExceptionConstants.KEY_NOT_FOUND);
	 }
}

}
