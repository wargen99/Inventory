package com.latis.wpc.service.security;

import java.util.HashMap;











import org.jasypt.springsecurity3.authentication.encoding.PasswordEncoder;
import org.jasypt.util.password.ConfigurablePasswordEncryptor;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.latis.wpc.security.userdetails.CustomUserDetails2;



public class UserService implements UserDetailsService {
	
	/**
	 * 스프링 내부 encrypt 모듈.
	 * start
	 */
	@Autowired
	private ShaPasswordEncoder encoder;
	
	@Autowired 
	private SaltSource saltSource;
	/**
	 * end
	 */
	
	
	/**
	 * jasypt
	 */
	@Autowired
	private PasswordEncoder password;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		
		System.out.println("!!!!!!!!!!"+encoder.encodePassword("gno11111111111111111111", saltSource));
		System.out.println("!!!!!!!!!!"+password.encodePassword("gno11111111111111111111", null));
		System.out.println("!!!!!!!!!!"+password.encodePassword("gno11111111111111111111", "aaaa"));
		
		
		
		
		if (username != null) {
			
			return new CustomUserDetails2(username, encoder.encodePassword("gno", saltSource), "ROLE_a" );
		} else {
			throw new AuthenticationCredentialsNotFoundException("");
		}
	}
	
	
}
