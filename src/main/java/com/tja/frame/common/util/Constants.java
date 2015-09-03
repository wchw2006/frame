package com.tja.frame.common.util;

import java.util.Properties;


/**
 * 系统常量
 * 
 * @author xiaoxin
 *
 */
public class Constants implements ConstantConfigurer {

	public static final String DYNAMIC_SUFFIX = ".jspx";

	public static String BACK_LOGIN_URL = "/back/login.do";
	
	public static String LOGIN_URL = "/login.jspx";
	public static String TEMPLATE_STORE_PATH = "/template";
	public static String TEMPLATE_DISPLAY_PATH = "/template";
	public static String STATIC_DISPLAY_PATH = "/static";
	public static boolean IS_ROOT_ALL_PERMS = false;

	public void loadProperties(Properties properties) {
		if (properties == null) {
			return;
		}
		String loginUrl = properties.getProperty("loginUrl");
		if (loginUrl != null) {
			LOGIN_URL = loginUrl;
		}
		String templateStorePath = properties.getProperty("templateStorePath");
		if (templateStorePath != null) {
			TEMPLATE_STORE_PATH = templateStorePath;
		}
		String templateDisplayPath = properties
				.getProperty("templateDisplayPath");
		if (templateDisplayPath != null) {
			TEMPLATE_DISPLAY_PATH = templateDisplayPath;
		}
		String staticDisplayPath = properties.getProperty("staticDisplayPath");
		if (staticDisplayPath != null) {
			STATIC_DISPLAY_PATH = staticDisplayPath;
		}
		String isRootAllPerms = properties.getProperty("isRootAllPerms");
		if ("true".equals(isRootAllPerms)) {
			IS_ROOT_ALL_PERMS = true;
		}
	}
}
