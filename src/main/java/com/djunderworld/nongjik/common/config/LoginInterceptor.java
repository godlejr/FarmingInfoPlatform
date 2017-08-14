package com.djunderworld.nongjik.common.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.djunderworld.nongjik.common.annotation.LoginRequired;
import com.djunderworld.nongjik.entity.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String context = request.getContextPath();
		String loginPageUrl = context + "/login";

		LoginRequired loginRequired = ((HandlerMethod)handler).getMethodAnnotation(LoginRequired.class);
			
		if (loginRequired != null) {
			HttpSession session = request.getSession(false);

			User user = (User) session.getAttribute("user");

			if (user == null) {
				response.sendRedirect(loginPageUrl);
				return false;
			}
		}

		return true;
	}

}
