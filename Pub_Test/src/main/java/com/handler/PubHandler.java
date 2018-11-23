package com.handler;

import java.util.List;

import org.apache.http.impl.client.NoopUserTokenHandler;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.pubapp.dao.PubDAO;
import com.pubapp.dao.PubDAOImpl;
import com.pubapp.model.ApplicationTab;
import com.pubapp.model.GetApplicationByAppIdRequest;
import com.pubapp.model.KeyValuePair;
import com.pubapp.model.NewUser;
import com.pubapp.model.PubRequest;
import com.pubapp.util.Action;
import com.pubapp.util.PubException;
import com.pubapp.util.PubExceptionConstants;
import com.pubapp.util.Response;
import com.pubapp.util.pubRequestValidator;

public class PubHandler implements RequestHandler<PubRequest, Object> {
	private DynamoDBMapper maper;
	private PubDAO dao;
	

	public Object handleRequest(PubRequest user, Context arg1)   {
		Object object=null;
		System.out.println(user);
		dao=new PubDAOImpl();
		arg1.getLogger().log("user" + user);
		dao.initDynamoDbClient();
		String acction=user.getAction();
		pubRequestValidator define=new pubRequestValidator();
		
		try {
			define.handlerexception(user);
			if(acction.equals("insertuser"))
			{
				NewUser newuser=user.getNewuser();
				define.usermissingexception(user);
				dao.persistData(newuser);
				
				
				
			}
			
			else if (acction.equals("updatekevalue"))  {

				List<KeyValuePair> keyvalue=user.getKeyvalue();
				define.keyvalueMissingException(user);
			
				dao.updateKeyValue(user.getUserid(), user.getAppid(),keyvalue,user.getToken());
				
			}
			else if(acction.equals("updateapplication"))
			{
				List<ApplicationTab> aaptab=user.getApplicationtab();
				define.updateApplicationMissingException(user);
				
				dao.updateapplication(user.getUserid(),aaptab,user.getToken());
			}
			else if (acction.equals("getapplicationbyappid")) {
				
			define.getaApplicationByIdMissingException(user);
			return	dao.getApplicationByAppid(user.getUserid(), user.getAppid(),user.getToken());
				
			}
			else if (acction.equals("getkeyvaluepairs")) {
				define.getKeyValuePairMissingException(user);
				
				return	dao.getkeyvaluepair(user.getUserid(), user.getAppid(),user.getToken());
				//
				
			}
			else if (acction.equals("getvalue")){
				define.getValueMissingException(user);
				
				return dao.getvalue(user.getUserid(), user.getAppid(), user.getKey(),user.getToken());
			}
		} catch (PubException ex) {
			
			Response response=new Response();
			response.setCode(ex.getCode());
			response.setMessage(ex.getMessage());
			response.setStatus(ex.getStatus());
			response.setData(ex.getData());
			return response;
			
		}
		
		//dao.persistData(user);
		//dao.updateKeyValue(user.getUid(), user.getApplicationtab().get(0).getAppid(),user.getApplicationtab().get(0).getKeyvaluepairs() );
	//dao.updateapplication(user.getUserid(), user.getApplicationtab());
	return null;
	}
	
}
