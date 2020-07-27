package com.mary.blog.config.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.mary.blog.config.handler.MyRoleException;
import com.mary.blog.config.handler.MySessionException;
import com.mary.blog.model.User;

//권한 관리
public class RoleIntercepter extends HandlerInterceptorAdapter{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User principal = (User)session.getAttribute("principal");
		
		if(principal == null) {
			System.out.println("RoleIntercepter : 인증이 안됨");
			throw new MySessionException(); // Exception을 던진다.
		}else{
			if(!principal.getRole().equals("ROLE_ADMIN")) {
				System.out.println("RoleIntercepter : 권한이 없음");
				throw new MyRoleException();
			}
		}
		return true;
	}
}





