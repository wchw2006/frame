package com.tja.frame.common.freemarker;

import java.io.IOException;
import java.util.List;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateException;

/**
 * FreeMarker配置类
 * 
 * @author liufang
 * 
 */
public class AdapterFreeMarkerConfigurer extends FreeMarkerConfigurer {
	@Override
	protected void postProcessTemplateLoaders(
			List<TemplateLoader> templateLoaders) {
		for (int i = 0, len = templateLoaders.size(); i < len; i++) {
			templateLoaders.set(i,
					new AdapterTemplateLoader(templateLoaders.get(i)));
		}
		super.postProcessTemplateLoaders(templateLoaders);
	}
	
	    @Override
	    public void afterPropertiesSet() throws IOException, TemplateException {
	        super.afterPropertiesSet();
	        this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
	    }
	
}
