package com.sqld.pettime.admin.beans;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AdminLoginSuccesHandler implements AuthenticationSuccessHandler {

	//login성공하면 호출하는 메소드
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("[로그인 성공!] onAuthenticationSuccess() 호출");
		// Authentication 객체를 이용해서 사용자가 가진 모든 권한을 문자열로 체크가능
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(auth -> {
			roleNames.add(auth.getAuthority());
		});
		
		System.out.println("ROLE NAMES: "+ roleNames);
		
		// 만약 사용자가 ROLE_ADMIN 권한을 가졌다면, 로그인 직후 곧바로 /Sample/admin으로 이동
		
		if(roleNames.contains("ROLE_ADMIN")) {
			UserDetails ud = (UserDetails) authentication.getPrincipal();
			System.out.println(ud.getUsername());
			response.sendRedirect(request.getContextPath() + "/admin/adminMain");
			
		}
		
		
		
	}

}
