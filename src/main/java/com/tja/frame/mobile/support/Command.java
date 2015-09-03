package com.tja.frame.mobile.support;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.util.StringUtils;

public class Command {

	private String id;
	
	private String clazz;
	
	private String method;

	public static Map<String,Command> parse(Map<String,String> cmdMap) {
		Map<String,Command> commands = new HashMap<String,Command>();
		
		for(Map.Entry<String, String> entry:cmdMap.entrySet()) {
			String key = entry.getKey();
			String value = entry.getValue();
			String[] arr = StringUtils.split(value, ';');
			if(arr.length != 2) {
				continue;
			}
			Command command = new Command(key,arr[0],arr[1]);
			commands.put(key, command);
		}
		return commands;
	}
	
	public Command(String id,String clazz,String method) {
		this.id = id;
		this.clazz = clazz;
		this.method = method;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	
}
