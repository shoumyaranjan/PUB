package com.handler;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.pubapp.dao.PubDAO;
import com.pubapp.dao.PubDAOImpl;
import com.pubapp.model.NewUser;

public class PubHandler implements RequestHandler<NewUser, String> {
	private DynamoDBMapper maper;
	private PubDAO dao;

	public String handleRequest(NewUser user, Context arg1) {
		dao=new PubDAOImpl();
		arg1.getLogger().log("user" + user);
		dao.initDynamoDbClient();
		//dao.persistData(user);
		//dao.updateKeyValue(user.getUid(), user.getApplicationtab().get(0).getAppid(),user.getApplicationtab().get(0).getKeyvaluepairs() );
		dao.updateapplication(user.getUid(), user.getApplicationtab());
		return user.toString();
	}
	
}
