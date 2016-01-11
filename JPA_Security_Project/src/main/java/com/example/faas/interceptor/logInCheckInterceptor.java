package com.example.faas.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;

public class logInCheckInterceptor extends HandlerInterceptorAdapter {

   @Override
	public boolean preHandle(HttpServletRequest req,
			HttpServletResponse response, Object arg) throws Exception {
		HttpSession session = req.getSession();
		String userId = (String) session.getAttribute("userId");

		if (userId == null) {
			response.sendRedirect("/faas/logIn");
			return false;
		}
		return true;
	}

}
