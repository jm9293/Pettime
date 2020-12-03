package com.sqld.pettime.admin.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class AdminAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		System.out.println("Access Denined Handler");
		System.out.println(accessDeniedException.getMessage());
		System.out.println("로그인에러");
		request.getSession().setAttribute("accessDeniedMessage", accessDeniedException.getMessage());
		System.out.println(accessDeniedException.getMessage());
	}

}
