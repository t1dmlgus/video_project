package com.example.spring01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.spring01.domain.MemberVO;

public class AdminInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception{
		
		HttpSession session = req.getSession();
		MemberVO member  = (MemberVO)session.getAttribute("sessionScope.verify");
		
		if(member == null || member.getVerify() != 7) {
			res.sendRedirect("/");
			return false;
		}
		
		
		
		
		
		return true;
	}
}
