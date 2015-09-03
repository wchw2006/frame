package com.tja.frame.common.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.LazyInitializer;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.PropertyFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class MyFastJsonHttpMessageConverter extends
		AbstractHttpMessageConverter<Object> {
	 public final static Charset UTF8     = Charset.forName("UTF-8");

	    private Charset             charset  = UTF8;

	    private SerializerFeature[] features = new SerializerFeature[0];

	    public MyFastJsonHttpMessageConverter(){
	        super(new MediaType("application", "json", UTF8), new MediaType("application", "*+json", UTF8));
	    }

	    @Override
	    protected boolean supports(Class<?> clazz) {
	        return true;
	    }

	    public Charset getCharset() {
	        return this.charset;
	    }

	    public void setCharset(Charset charset) {
	        this.charset = charset;
	    }

	    public SerializerFeature[] getFeatures() {
	        return features;
	    }

	    public void setFeatures(SerializerFeature... features) {
	        this.features = features;
	    }

	    @Override
	    protected Object readInternal(Class<? extends Object> clazz, HttpInputMessage inputMessage) throws IOException,
	                                                                                               HttpMessageNotReadableException {

	        ByteArrayOutputStream baos = new ByteArrayOutputStream();

	        InputStream in = inputMessage.getBody();

	        byte[] buf = new byte[1024];
	        for (;;) {
	            int len = in.read(buf);
	            if (len == -1) {
	                break;
	            }

	            if (len > 0) {
	                baos.write(buf, 0, len);
	            }
	        }

	        byte[] bytes = baos.toByteArray();
	        return JSON.parseObject(bytes, 0, bytes.length, charset.newDecoder(), clazz);
	    }

	    @Override
	    protected void writeInternal(Object obj, HttpOutputMessage outputMessage) throws IOException,
	                                                                             HttpMessageNotWritableException {

	        OutputStream out = outputMessage.getBody();
	        JSON.toJSONString(obj, new SimplePropertyFilter(), features);
	        String text = JSON.toJSONString(obj, features);
	        byte[] bytes = text.getBytes(charset);
	        out.write(bytes);
	    }
	    
	    public class SimplePropertyFilter implements PropertyFilter {  
	    	  
	        /** 
	         * 过滤不需要被序列化的属性，主要是应用于Hibernate的代理和管理。 
	         * @param object 属性所在的对象 
	         * @param name 属性名 
	         * @param value 属性值 
	         * @return 返回false属性将被忽略，ture属性将被保留 
	         */  
	        @Override  
	        public boolean apply(Object object, String name, Object value) {  
	            if (value instanceof HibernateProxy) {//hibernate代理对象  
	                LazyInitializer initializer = ((HibernateProxy) value).getHibernateLazyInitializer(); 
	                if (initializer.isUninitialized()) {  
	                    return false;  
	                }  
	            } else if (value instanceof PersistentCollection) {//实体关联集合一对多等  
	                PersistentCollection collection = (PersistentCollection) value;  
	                if (!collection.wasInitialized()) {  
	                    return false;  
	                }  
	                Object val = collection.getValue();  
	                if (val == null) {  
	                    return false;  
	                }  
	            }  
	            return true;  
	        }  
	      
	    }  

}
