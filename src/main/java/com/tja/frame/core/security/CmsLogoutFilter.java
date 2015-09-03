package com.tja.frame.core.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.LogoutFilter;
import org.springframework.beans.factory.annotation.Autowired;



public class CmsLogoutFilter extends LogoutFilter {
	/**
	 * 返回URL
	 */
	public static final String FALLBACK_URL_PARAM = "fallbackUrl";


	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response)
			throws Exception {
		/*Subject subject = getSubject(request, response);
		Object principal = subject.getPrincipal();
		String ip = Servlets.getRemoteAddr(request);
		boolean result = super.preHandle(request, response);

		if (principal != null) {
			logService.logout(ip, principal.toString());
		}
		return result;*/
		return true;
	}

	/*protected String getRedirectUrl(ServletRequest req, ServletResponse resp,
			Subject subject) {
		HttpServletRequest request = (HttpServletRequest) req;
		String redirectUrl = request.getParameter(FALLBACK_URL_PARAM);
		if (StringUtils.isBlank(redirectUrl)) {
			if (request.getRequestURI().startsWith(
					request.getContextPath() + backUrl)) {
				redirectUrl = getBackRedirectUrl();
			} else {
				redirectUrl = getRedirectUrl();
			}
		}
		return redirectUrl;
	}

	public String getBackRedirectUrl() {
		return backRedirectUrl;
	}

	public void setBackRedirectUrl(String backRedirectUrl) {
		this.backRedirectUrl = backRedirectUrl;
	}

	public String getBackUrl() {
		return backUrl;
	}

	public void setBackUrl(String backUrl) {
		this.backUrl = backUrl;
	}

	private OperationLogService logService;

	@Autowired
	public void setOperationLogService(OperationLogService logService) {
		this.logService = logService;
	}*/
}
