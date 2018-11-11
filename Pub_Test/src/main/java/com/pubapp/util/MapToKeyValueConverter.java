package com.pubapp.util;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pubapp.model.KeyValuePair;

public class MapToKeyValueConverter {

	public static List<KeyValuePair> convert(List<KeyValuePair> kvpairs){
		List<KeyValuePair> tempKVPS=new ArrayList<KeyValuePair>();
		for(int i=0;i<kvpairs.size();i++){
			if(kvpairs.get(i) instanceof Map){
			Map<String, Object> map=(Map<String, Object>) kvpairs.get(i);
			System.out.println(map);
			KeyValuePair kvp=new KeyValuePair();
				kvp.setKey((String) map.get("key"));
				kvp.setValue(map.get("value"));
			tempKVPS.add(kvp);
		}}
		if(tempKVPS.size()!=0)
		return tempKVPS;
		else
			return kvpairs;
	}
}
