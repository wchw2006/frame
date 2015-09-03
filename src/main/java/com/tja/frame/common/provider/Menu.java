package com.tja.frame.common.provider;

import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.shiro.util.StringUtils;

public class Menu implements Comparable<Menu> {

	private String  id;

	private String name;

	private String url;
	
	private String perm;
	
	private int seq;
	
	private String parentId;
	
	private Menu parent;
	
	private Set<Menu> children;
	
	/**
	 *  根据配置字符串解析封装成menu对象.
	 *  
	 * @param id
	 *         menu ID 如:  0.100
	 * @param menuStr
	 *         menu配置信息 
	 * @return
	 */
	public static Menu parse(String id,String menuStr) {
		if(null == id  && id.isEmpty()) {
			throw new IllegalArgumentException("the reference id is null or empty!");
		}
		if(null == menuStr && menuStr.isEmpty()) {
			throw new IllegalArgumentException("the menuStr id is null or empty!");
		}
		
		String[] arr = StringUtils.split(menuStr, ';');
		int len = arr.length;
		Menu m = new Menu();
		m.setId(id);
		m.setName(arr[0]);
		if(len>1) {
			m.setUrl(arr[1]);
		}
		if(len>2) {
			m.setPerm(arr[2]);
		}
		
		String[] seqArr = StringUtils.split(id, '.');
		int seq = NumberUtils.toInt(seqArr[seqArr.length - 1],
				Integer.MAX_VALUE);
		m.setSeq(seq);
		if (id.indexOf('.') != -1) {
			String parentId = id.substring(0, id.lastIndexOf('.'));
		    m.setParentId(parentId);
		}
		return m;
	}
	
	public void addChild(Menu m) {
		if (children == null) {
			children = new TreeSet<Menu>();
		}
		children.add(m);
	}
	
	@Override
	public int compareTo(Menu o) {
		return this.getSeq() - o.getSeq();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPerm() {
		return perm;
	}

	public void setPerm(String perm) {
		this.perm = perm;
	}


	public int getSeq() {
		return seq;
	}


	public void setSeq(int seq) {
		this.seq = seq;
	}


	public String getParentId() {
		return parentId;
	}


	public void setParentId(String parentId) {
		this.parentId = parentId;
	}


	public Menu getParent() {
		return parent;
	}


	public void setParent(Menu parent) {
		this.parent = parent;
	}


	public Set<Menu> getChildren() {
		if(null == this.children) {
			this.children = new TreeSet<Menu>();
		}
		return this.children;
	}


	public void setChildren(Set<Menu> children) {
		this.children = children;
	}
	
}
