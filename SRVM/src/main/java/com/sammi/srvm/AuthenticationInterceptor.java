package com.sammi.srvm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sammi.srvm.dao.SelectDAO;
import com.sammi.srvm.dto.EmpDTO;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	SelectDAO selectdao;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception{
		
		System.out.println("Interceptor start..");
		
		HttpSession session = request.getSession();
		
		Object obj = session.getAttribute("login");
		
		if (obj == null) {
			System.out.println("obj is null!");
			response.sendRedirect("login");
			return false;
		}else {
			
			
			
		}
		
		
		
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView mav) throws Exception {
		super.postHandle(request, response, handler, mav);
	}

}
