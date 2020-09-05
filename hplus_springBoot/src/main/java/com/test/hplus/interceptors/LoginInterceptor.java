package com.test.hplus.interceptors;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter
{
//If you want to create custom interceptor just extends above class and overide one of its method.
//Pre handle -Before controller is getting called
//Post handle -After controller finished its execution and return back to its intercepttors
	//after completion once the response is committed-Means once the response is rendered on jsp page that the time this interceptors is getting called
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//get allo cookies
		String sessionId= null;
				if(null!=request.getCookies())
				{
					for(Cookie cookie:request.getCookies())
					{
						if("JSESSIONID".equals(cookie.getName()))
						{
							sessionId=cookie.getValue();
						}
					}
				}
				
				System.out.println("Incoming data log session id "+sessionId + "at" +new Date() + "for" + request.getRequestURI());
				return true;
		
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
			System.out.println("In Post handle");	}
}
