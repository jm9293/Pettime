package com.sqld.pettime.designer.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class DesignerAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		System.out.println("Access Denined Handler");
		System.out.println(accessDeniedException.getMessage());
		System.out.println("로그인에러");
		request.getSession().setAttribute("loginFailMsg", accessDeniedException.getMessage());
		System.out.println(accessDeniedException.getMessage());
		
		response.sendRedirect(request.getContextPath()+"/designer/login");
	}

}
