package com.latis.redis;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.latis.wpc.security.userdetails.CustomUserDetails2;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/home2.do", method = RequestMethod.GET)
	public String home2(Model model, Authentication auth) {
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) auth.getAuthorities();
//		System.out.println(authorities.get(0).getAuthority());
		String strAuth = authorities.get(0).getAuthority();
		
		CustomUserDetails2 details2 = (CustomUserDetails2) auth.getPrincipal();
		
		model.addAttribute("auth", strAuth);
		
		model.addAttribute("credential", auth.getCredentials());
		model.addAttribute("principal", details2.getUsername());
		
		
		return "home2";
	}
	
}
