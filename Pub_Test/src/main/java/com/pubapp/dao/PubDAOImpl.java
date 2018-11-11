package com.pubapp.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.google.gson.Gson;
import com.pubapp.model.ApplicationTab;
import com.pubapp.model.KeyValuePair;
import com.pubapp.model.NewUser;
import com.pubapp.util.MapToKeyValueConverter;

public class PubDAOImpl implements PubDAO {
	private  DynamoDBMapper mapper;
	
	public void initDynamoDbClient() {
		AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
		this.mapper = new DynamoDBMapper(client);
	}

	public ApplicationTab getApplicationByAppid(String userId, int appId) {
		System.out.println(mapper);
		NewUser user=mapper.load(NewUser.class, userId);
		List<ApplicationTab> list=user.getApplicationtab();
		ApplicationTab app=getApplicationById(list, appId);
		if(app!=null){
			return app;
		}
		return null;
	}
	
	
	public List<KeyValuePair> getkeyvaluepair(String userId,int appId )
	{
		NewUser user=mapper.load(NewUser.class,userId);
		ApplicationTab tab=getApplicationByAppid(userId, appId);
		List<KeyValuePair>list=tab.getKeyvaluepairs();
					
		return list ;
		
	}
	public Object getvalue(String userId,int appId,String key)
	{
		Object object=null;
		//List<KeyValuePair> exitkeyvalue=new ArrayList<KeyValuePair>();
		List<KeyValuePair> pair= getkeyvaluepair(userId, appId);
		 
		 for(KeyValuePair keyvalue:pair)
		 {
			 if(keyvalue.getKey().equals(key))
			 {
				  object=keyvalue.getValue();
				  break;
			 }
			// return object;
		 }
		
		return object;
		
	}

	public ApplicationTab getApplicationById(List<ApplicationTab> list, int appId) {
		for(ApplicationTab app:list){
			if(app.getAppid()==appId){
				return app;
			}
		}
		return null;
	}
	
	public int getApplicationIndex(List<ApplicationTab> list, int appId){
		
		for(int i=0;i<list.size();i++){
			if(list.get(i).getAppid()==appId)
			{
				return i;
			}
		}
		return -1;
	}

	public void persistData(NewUser user) {
		List<ApplicationTab>list=user.getApplicationtab();
		int  applicationtabsize =user.getLastapplicationid();   
		for(ApplicationTab app:list){
			if(app.getAppid()==0){
				applicationtabsize=applicationtabsize+1;
				app.setAppid(applicationtabsize);
				user.setLastapplicationid(applicationtabsize);
			}
		}
		
		//applicationtabsize=applicationtabsize+1;
		
		mapper.save(user);

	}
	
	public void updateKeyValue(String userId, int appId, List<KeyValuePair> kvpairs) {
		
		ApplicationTab applicationTab=getApplicationByAppid(userId, appId);
		if(applicationTab!=null){
		List<KeyValuePair> existingKVPs=applicationTab.getKeyvaluepairs();
		List<KeyValuePair> updatedPairs=new ArrayList<KeyValuePair>();
		List<KeyValuePair> tempPairs=new ArrayList<KeyValuePair>();
		tempPairs.addAll(kvpairs);
	//	List<KeyValuePair> tempPairs1=new ArrayList<KeyValuePair>();
		//tempPairs1.addAll(existingKVPs);
		System.out.println(existingKVPs);		
		existingKVPs=MapToKeyValueConverter.convert(existingKVPs);
		kvpairs=MapToKeyValueConverter.convert(kvpairs);
		System.out.println(existingKVPs);
		boolean found=false;
	for(KeyValuePair existkey: existingKVPs)
	{
		found=false;
		for(KeyValuePair newPair:kvpairs){
			if(existkey.getKey().equals(newPair.getKey())){
				System.out.println("key :"+existkey.getKey());
				System.out.println("value :"+existkey.getValue());
				existkey.setValue(newPair.getValue());
				tempPairs.remove(newPair);
				tempPairs.add(existkey);
				found=true;
				//tempPairs1.remove(newPair);
				break;
			}
		}
		
		if(found==false){
			updatedPairs.add(existkey);
		}
		
	}
	updatedPairs.addAll(tempPairs);
	//updatedPairs.addAll(tempPairs1);
	System.out.println(updatedPairs);
	applicationTab.setKeyvaluepairs(updatedPairs);
	NewUser user=mapper.load(NewUser.class, userId);
	user.getApplicationtab().remove(getApplicationIndex(user.getApplicationtab(), appId));
	user.getApplicationtab().add(applicationTab);
	persistData(user);
	
		}
	}
	
	public void updateapplication( String userId,  List<ApplicationTab>applicationlist)
	{
		
		NewUser user=mapper.load(NewUser.class, userId);
		List<ApplicationTab> exitapplication=user.getApplicationtab();
		
	//	ApplicationTab app=getApplicationById(list, appId);
		List<ApplicationTab> tempApps=new ArrayList<ApplicationTab>();
		tempApps.addAll(applicationlist);
		List<ApplicationTab>updateapptab=new ArrayList<ApplicationTab>();	
		boolean found=false;
		
		for(ApplicationTab apptab:exitapplication)
		{	found=false;		
			for(ApplicationTab newapplication:applicationlist)
			{
				if(apptab.getAppname().equals(newapplication.getAppname()))
				{
					System.out.println("appid"+apptab.getAppid());
					System.out.println("appname"+apptab.getAppname());
					tempApps.remove(newapplication);
					//updateKeyValue(userId, apptab.getAppid(), apptab.getKeyvaluepairs());
					found=true;
					updateapptab.add(newapplication);
					break;
				}				
			}	
			if(found==false)
			{
				updateapptab.add(apptab);
			}
			
		}
		
		updateapptab.addAll(tempApps);
		System.out.println(updateapptab);
		NewUser user1=mapper.load(NewUser.class, userId);
		user1.setApplicationtab(updateapptab);
		persistData(user1);
	
	}
	
	

}


