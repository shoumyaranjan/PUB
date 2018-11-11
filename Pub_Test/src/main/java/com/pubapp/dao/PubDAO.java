package com.pubapp.dao;

import java.util.List;

import com.pubapp.model.ApplicationTab;
import com.pubapp.model.KeyValuePair;
import com.pubapp.model.NewUser;

public interface PubDAO {
	void initDynamoDbClient();
	ApplicationTab getApplicationByAppid(String userId,int appId);
	ApplicationTab getApplicationById(List<ApplicationTab> list,int appId);
	List<KeyValuePair> getkeyvaluepair(String userId,int appId );
	Object getvalue(String userId,int appId,String key);
	void persistData(NewUser user);
	void updateKeyValue(String userId,int appId,List<KeyValuePair> kvpairs);
    void updateapplication( String userId,  List<ApplicationTab>applicationlist);
}
