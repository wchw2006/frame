package com.tja.frame.web.fore;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.tja.frame.common.provider.MenuProvider;
import com.tja.frame.common.util.JsonUtil;
import com.tja.frame.core.domain.Organization;
import com.tja.frame.core.domain.User;
import com.tja.frame.core.service.UserService;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	UserService userService;
	
	@Autowired
	MenuProvider menuProvider;
	
	@RequestMapping(value="/hello.do")
	@ResponseBody
	public User  sayJson() {
		User user = userService.findByUserName("5876");
		return user;
	}
	
	@RequestMapping(value="/index.do")
	public ModelAndView  sayHelllo() {
		ModelAndView v = new ModelAndView("index.ftl");
		
		v.getModel().put("name", "xiaoxin");
		v.getModel().put("menus", menuProvider.getMenus());
		return v;
	}
	
	@RequestMapping(value="/getJson.do",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String  sayString() {
		User user = userService.findByUserName("5876");
		Map<Class<?>,String[]> excludes = new HashMap<Class<?>,String[]>();
		excludes.put(User.class, new String[]{"userRoles","salt"});
		Map<Class<?>,String[]> includes = new HashMap<Class<?>,String[]>();
		includes.put(Organization.class, new String[]{"id","name"});
		
		String jonsStr = JsonUtil.toJsonString(user, excludes, includes);
		return jonsStr;
	}
	
}  
