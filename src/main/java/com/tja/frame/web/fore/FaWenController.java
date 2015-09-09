package com.tja.frame.web.fore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tja.frame.common.provider.MenuProvider;

@Controller
@RequestMapping("/fawen")
public class FaWenController {
	
	@Autowired
	MenuProvider menuProvider;
	
	@RequestMapping(value="/add.do")
	public ModelAndView  addFlow() {
		ModelAndView v = new ModelAndView("fawen/fawen_add");
		
		v.getModel().put("name", "xiaoxin");
		v.getModel().put("menus", menuProvider.getMenus());
		return v;
	}
	
	@RequestMapping(value="/view.do")
	public ModelAndView  viewFlow() {
		ModelAndView v = new ModelAndView("fawen/fawen_view");
		
		v.getModel().put("name", "xiaoxin");
		v.getModel().put("menus", menuProvider.getMenus());
		return v;
	}

}
