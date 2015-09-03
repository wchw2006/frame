package com.tja.frame.common.provider;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;

public class MenuProvider {

	private Set<Menu> menus;

	public static Set<Menu> assemble(Map<String, String> map) {
		Map<String,Menu> menus = new HashMap<String,Menu>();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			Menu m = Menu.parse(entry.getKey(), entry.getValue());
		menus.put(m.getId(), m);
		}
		return init(menus);
	}
	
	public static Set<Menu> init(Map<String,Menu> menus) {
		Set<Menu> set = new TreeSet<Menu>();
		Collection<Menu> col = menus.values();
		for(Menu m:col) {
			 //  返回根结点
			if(StringUtils.isNotEmpty(m.getParentId())){
				Menu parent = menus.get(m.getParentId());
				m.setParent(parent);
				parent.addChild(m);
			} else {
				set.add(m);	
			}
		}
		return  set;
	}
	
	public Set<Menu> getMenus() {
		return menus;
	}

	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}
	
}
