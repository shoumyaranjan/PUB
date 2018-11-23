package com.pubapp.dao;

import java.util.List;

import com.pubapp.model.ApplicationTab;
import com.pubapp.model.KeyValuePair;
import com.pubapp.model.NewUser;
import com.pubapp.util.PubException;

public interface PubDAO {
	void initDynamoDbClient();
	ApplicationTab getApplicationByAppid(String userId,int appId,String token) throws PubException;
	ApplicationTab getApplicationById(List<ApplicationTab> list,int appId) ;
	List<KeyValuePair> getkeyvaluepair(String userId,int appId,String token ) throws PubException;
	Object getvalue(String userId,int appId,String key,String token) throws PubException;
	Object persistData(NewUser user) throws PubException ;
	void updateKeyValue(String userId,int appId,List<KeyValuePair> kvpairs,String token)throws PubException;
    void updateapplication( String userId,  List<ApplicationTab>applicationlist,String token) throws PubException;
    NewUser getuserbyemail(String Uemail );
    void validateDuplicateUser(String Uemail) throws PubException;
//	NewUser getEmailByEmailis(String userId, String uemail);
}
