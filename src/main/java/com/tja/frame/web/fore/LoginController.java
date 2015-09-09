package com.tja.frame.web.fore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tja.frame.common.provider.MenuProvider;

@Controller
public class LoginController {
	
	@Autowired
	MenuProvider menuProvider;
	
	@RequestMapping({"/","/index.do"})
	public ModelAndView  index() {
		ModelAndView v = new ModelAndView("index");
		
		v.getModel().put("name", "xiaoxin");
		v.getModel().put("menus", menuProvider.getMenus());
		return v;
	}
	
	@RequestMapping(value="/login.do")
	public ModelAndView  login() {
		ModelAndView v = new ModelAndView("login");
		
		v.getModel().put("name", "xiaoxin");
		v.getModel().put("menus", menuProvider.getMenus());
		return v;
	}

}
