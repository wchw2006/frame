package com.tja.frame.common.freemarker;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.tja.frame.web.Servlets;

import freemarker.core.StringArraySequence;
import freemarker.template.SimpleCollection;
import freemarker.template.TemplateCollectionModel;
import freemarker.template.TemplateHashModelEx;
import freemarker.template.TemplateModel;

/**
 * FreeMarker ParamValues参数模型
 * 
 * @author liufang
 * 
 */
public class HttpRequestParameterValuesHashModel implements TemplateHashModelEx {
	private final HttpServletRequest request;
	private final Map<String, String[]> queryStringMap;
	private List<String> keys;

	public HttpRequestParameterValuesHashModel(HttpServletRequest request) {
		this.request = request;
		this.queryStringMap = Servlets.parseQueryString(request
				.getQueryString());
	}

	public TemplateModel get(String key) {
		String[] value = Servlets.getParameterValues(request, queryStringMap,
				key);
		return value == null ? null : new StringArraySequence(value);
	}

	public boolean isEmpty() {
		return !request.getParameterNames().hasMoreElements();
	}

	public int size() {
		return getKeys().size();
	}

	public TemplateCollectionModel keys() {
		return new SimpleCollection(getKeys().iterator());
	}

	public TemplateCollectionModel values() {
		final Iterator<String> iter = getKeys().iterator();
		return new SimpleCollection(new Iterator<String[]>() {
			public boolean hasNext() {
				return iter.hasNext();
			}

			public String[] next() {
				return Servlets.getParameterValues(request, queryStringMap,
						iter.next());
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		});
	}

	protected String transcode(String string) {
		return string;
	}

	@SuppressWarnings("unchecked")
	private synchronized List<String> getKeys() {
		if (keys == null) {
			keys = new ArrayList<String>();
			for (Enumeration<String> enumeration = request.getParameterNames(); enumeration
					.hasMoreElements();) {
				keys.add(enumeration.nextElement());
			}
		}
		return keys;
	}
}