package com.tja.frame.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
	public static List<Map<String, Object>> getList(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		JSONArray jsonArray = getJsonArray(jsonString);
		try {
			for (int i = 0; i < jsonArray.size(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				list.add(getMap(jsonObject.toString()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@SuppressWarnings("static-access")
	public static JSONArray getJsonArray(String jsonString){
		JSONArray jsonArray = new JSONArray();
		try {
			jsonArray = jsonArray.parseArray(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
	
	public static Map<String, Object> getMap(String jsonString) {
		JSONObject jsonObject = getJSON(jsonString);
		Map<String, Object> valueMap = new HashMap<String, Object>();
		try {
			Set<String> keySet = jsonObject.keySet();
			Iterator<String> keyIter = keySet.iterator();
			String key;
			Object value;
			while (keyIter.hasNext()) {
				key = (String) keyIter.next();
				value = jsonObject.get(key);
				valueMap.put(key, value);
			}
		} catch (JSONException e) {
		}
		return valueMap;
	}
	
	@SuppressWarnings("static-access")
	public static JSONObject getJSON(String jsonString) {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = jsonObject.parseObject(jsonString);
		} catch (Exception e) {
		}
		return jsonObject;
	}

	
	public static String mapTojson(Map<String , String> map){
		String json = "";
		if(null != map){
			json = JSONObject.toJSON(map).toString();
		}
		return json;
	}
	
	
	public static String listMapTojson(List<Map<String, Object>> listmap){
		String json = "";
		if(null != listmap){
			json = JSONObject.toJSON(listmap).toString();
		}
		return json;
	}
	
	public static String toJsonString(Object obj,Map<Class<?>,String[]> excludes,Map<Class<?>,String[]> includes) {
		if(null == obj) {
			return null;
		}
		ComplexPropertyPreFilter  filter = new ComplexPropertyPreFilter ();
		if(null != excludes) {
			filter.setExcludes(excludes);
		}
		if(null != includes) {
			filter.setIncludes(includes);
		}
		return JSON.toJSONString(obj,filter);
	}
}
