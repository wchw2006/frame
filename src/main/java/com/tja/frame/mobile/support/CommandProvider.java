package com.tja.frame.mobile.support;

import java.util.Map;

public class CommandProvider {

	public Map<String,Command>  commandMap;

	public Map<String, Command> getCommandMap() {
		return commandMap;
	}

	public void setCommandMap(Map<String, Command> commandMap) {
		this.commandMap = commandMap;
	}

	public Command  findCommandByKey(String key) {
		if(null == commandMap) {
			return null;
		}
		return commandMap.get(key);
	}
}
