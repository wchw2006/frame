package com.tja.frame.core.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import com.tja.frame.common.util.Constants;

/**
 * CmsAuthenticationFilter
 * 
 * @author liufang
 * 
 */
public class CmsAuthenticationFilter extends FormAuthenticationFilter {
	private Logger logger = LoggerFactory
			.getLogger(CmsAuthenticationFilter.class);
	/**
	 * 是否需要验证码
	 */
	public static final String CAPTCHA_REQUIRED_KEY = "shiroCaptchaRequired";
	/**
	 * 验证码错误次数
	 */
	public static final String CAPTCHA_ERROR_COUNT_KEY = "shiroCaptchaErrorCount";
	/**
	 * 验证码名称
	 */
	public static final String CAPTCHA_PARAM = "captcha";
	/**
	 * 返回URL
	 */
	public static final String FALLBACK_URL_PARAM = "fallbackUrl";
	

	@Override
	protected boolean executeLogin(ServletRequest request,
			ServletResponse response) throws Exception {/*
		AuthenticationToken token = createToken(request, response);
		if (token == null) {
			String msg = "createToken method implementation returned null. A valid non-null AuthenticationToken "
					+ "must be created in order to execute a login attempt.";
			throw new IllegalStateException(msg);
		}
		String username = (String) token.getPrincipal();
		User user = userShiroService.findByUsername(username);
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse hsp = (HttpServletResponse) response;
		if (isCaptchaSessionRequired(hsr, hsp) || user != null
				&& user.isCaptchaRequired()) {
			String captcha = request.getParameter(CAPTCHA_PARAM);
			if (captcha != null) {
				if (!Captchas.isValid(captchaService, hsr, captcha)) {
					return onLoginFailure(token,
							new IncorrectCaptchaException(), request, response);
				}
			} else {
				return onLoginFailure(token, new CaptchaRequiredException(),
						request, response);
			}
		}
		String ip = Servlets.getRemoteAddr(request);
		try {
			Subject subject = getSubject(request, response);
			subject.login(token);
			logService.loginSuccess(ip, user.getId());
			return onLoginSuccess(token, subject, request, response);
		} catch (AuthenticationException e) {
			Object cred = token.getCredentials();
			String password = "";
			if (cred instanceof char[]) {
				password = new String((char[]) cred);
			}
			logService.loginFailure(username + ":" + password, ip);
			return onLoginFailure(token, e, request, response);
		}
	*/
	return true;
	}

	@Override
	public boolean onPreHandle(ServletRequest request,
			ServletResponse response, Object mappedValue) throws Exception {
		boolean isAllowed = isAccessAllowed(request, response, mappedValue);
		if (isAllowed && isLoginRequest(request, response)) {
			try {
				issueSuccessRedirect(request, response);
			} catch (Exception e) {
				logger.error("", e);
			}
			return false;
		}
		return isAllowed || onAccessDenied(request, response, mappedValue);
	}

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		/*ShiroUser shiroUser = (ShiroUser) subject.getPrincipal();
		String ip = Servlets.getRemoteAddr(request);
		userShiroService.updateLoginSuccess(shiroUser.id, ip);
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse hsp = (HttpServletResponse) response;
		// 清除需要验证码的session
		removeCaptchaSession(hsr, hsp);*/
		return super.onLoginSuccess(token, subject, request, response);
	}

	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest request,
			ServletResponse response) {
		/*String username = (String) token.getPrincipal();
		HttpServletRequest hsr = (HttpServletRequest) request;
		HttpServletResponse hsp = (HttpServletResponse) response;
		HttpSession session = hsr.getSession();
		Integer errorCount = (Integer) session
				.getAttribute(CAPTCHA_ERROR_COUNT_KEY);
		if (errorCount != null) {
			errorCount++;
		} else {
			errorCount = 1;
		}
		session.setAttribute(CAPTCHA_ERROR_COUNT_KEY, errorCount);
		User user = userShiroService.updateLoginFailure(username);
		if (errorCount > 3 || (user != null && user.isCaptchaRequired())) {
			// 加入需要验证码的session
			addCaptchaSession(hsr, hsp);
		}*/
		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected void issueSuccessRedirect(ServletRequest req, ServletResponse resp)
			throws Exception {
	/*	HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String successUrl = request.getParameter(FALLBACK_URL_PARAM);
		if (StringUtils.isBlank(successUrl)) {
			if (request.getRequestURI().startsWith(
					request.getContextPath() + backUrl)) {
				// 后台直接返回首页
				successUrl = getBackSuccessUrl();
				// 清除SavedRequest
				WebUtils.getAndClearSavedRequest(request);
				WebUtils.issueRedirect(request, response, successUrl, null,
						true);
				return;
			} else {
				successUrl = getSuccessUrl();
			}
		}
		WebUtils.redirectToSavedRequest(request, response, successUrl);*/
	}

	@Override
	protected boolean isLoginRequest(ServletRequest req, ServletResponse resp) {
		return pathsMatch(getLoginUrl(), req)
				|| pathsMatch(Constants.BACK_LOGIN_URL, req);
	}

	protected void removeCaptchaSession(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute(CAPTCHA_REQUIRED_KEY);
			session.removeAttribute(CAPTCHA_ERROR_COUNT_KEY);
		}
	}

	protected void addCaptchaSession(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.setAttribute(CAPTCHA_REQUIRED_KEY, true);
	}

	protected boolean isCaptchaSessionRequired(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			return session.getAttribute(CAPTCHA_REQUIRED_KEY) != null;
		}
		return false;
	}

}
