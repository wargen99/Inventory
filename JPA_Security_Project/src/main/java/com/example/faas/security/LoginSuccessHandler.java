package com.example.faas.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.example.faas.dtoex.Person;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println(auth.getAuthorities().getClass().getName());
		
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
		String strAuth = authorities.get(0).getAuthority();
	    
		CustomUserDetail userDetail = (CustomUserDetail) auth.getPrincipal();
		
		Person person = userDetail.getPerson();
	    
		Cookie cookie = new Cookie("userInfo", person.toString());
		cookie.setPath("/");
		// ���߿� ������Ƽ�� ����
//		cookie.setDomain("test.com");
		response.addCookie(cookie);
		
		response.sendRedirect(request.getContextPath() +  "/ProjectList");
		
	}

}
