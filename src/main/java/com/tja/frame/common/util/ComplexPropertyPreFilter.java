package com.tja.frame.common.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.shiro.util.CollectionUtils;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.PropertyPreFilter;

public class ComplexPropertyPreFilter implements PropertyPreFilter {
    
    private Map<Class<?>, String[]> includes = new HashMap<Class<?>,String[]>();
    private Map<Class<?>, String[]> excludes = new HashMap<Class<?>,String[]>();
          
   /* static {
        JSON.DEFAULT_GENERATE_FEATURE |= SerializerFeature.DisableCircularReferenceDetect.getMask();
    }*/
          
    public ComplexPropertyPreFilter() {
              
    }
          
    public ComplexPropertyPreFilter(Map<Class<?>, String[]> includes) {
        super();
        this.includes = includes;
    }
          
    public boolean apply(JSONSerializer serializer, Object source, String name) {
        //对象为空。直接放行
        if (source == null) {
            return true;
        }
        
        // 获取当前需要序列化的对象的类对象
        Class<?> clazz = source.getClass();
        Set<Class<?>> includeClazzs = new HashSet<Class<?>>();
        // 需要序列的对象
        // 找到不需要的序列化的类型
        for (Map.Entry<Class<?>, String[]> item : this.includes.entrySet()) {
            // isAssignableFrom()，用来判断类型间是否有继承关系
            if (item.getKey().isAssignableFrom(clazz)) {
            	includeClazzs.add(item.getKey());
                String[] strs = item.getValue();
                // 该类型下 此 name 值无需序列化
                if (isHave(strs, name)) {
                    return true;
                }
            }
        }
         
        if(!CollectionUtils.isEmpty(this.includes)) {  //如果source设置了inclues，则不进行excludes判断
        	 Set<Class<?>> keys = this.includes.keySet();
        	 if(this.containClazz(keys, clazz)) {
        		 return false;
        	 }
        }
              
        // 无需序列的对象、寻找需要过滤的对象，可以提高查找层级
        // 找到不需要的序列化的类型
        for (Map.Entry<Class<?>, String[]> item : this.excludes.entrySet()) {
            // isAssignableFrom()，用来判断类型间是否有继承关系
            if (item.getKey().isAssignableFrom(clazz)) {
                String[] strs = item.getValue();
                      
                // 该类型下 此 name 值无需序列化
                if (isHave(strs, name)) {
                    return false;
                }
            }
        }
              
        return true;
    }
          
    public boolean containClazz(Set<Class<?>> clazzs,Class<?> clazz) {
    	if(CollectionUtils.isEmpty(clazzs))	{
    		return false;
    	}
    	for(Class<?> c:clazzs) {
    		System.out.println(c);
    		if(c.isAssignableFrom(clazz)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /*
     * 此方法有两个参数，第一个是要查找的字符串数组，第二个是要查找的字符或字符串
     */
    public  boolean isHave(String[] strs, String s) {
              
        for (int i = 0; i < strs.length; i++) {
            // 循环查找字符串数组中的每个字符串中是否包含所有查找的内容
            if (strs[i].equals(s)) {
                // 查找到了就返回真，不在继续查询
                return true;
            }
        }
              
        // 没找到返回false
        return false;
    }
          
    public Map<Class<?>, String[]> getIncludes() {
        return includes;
    }
          
    public void setIncludes(Map<Class<?>, String[]> includes) {
        this.includes = includes;
    }
          
    public Map<Class<?>, String[]> getExcludes() {
        return excludes;
    }
          
    public void setExcludes(Map<Class<?>, String[]> excludes) {
        this.excludes = excludes;
    }

}
