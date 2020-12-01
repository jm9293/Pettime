package com.sqld.pettime.admincontroller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.admin.command.adResListCommand;
import com.admin.command.adminMainCommand;
import com.admin.common.C;

@Controller
@RequestMapping("/admin")
public class CommonController {
	
	// MyBatis
	private SqlSession sqlSession;
	
	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		C.sqlSession = sqlSession;
	}

	@RequestMapping("/adminLogin")
	public void doLogin() {
		System.out.println("login������");
	}
	
	@RequestMapping("/adminMain")
	public void goMain(Model model) {
		System.out.println("����������");
		new adminMainCommand().execute(model);
	}
	
	@RequestMapping("/adRes")
	public void goRed(Model model) {
		System.out.println("����Ȯ��������");
		new adResListCommand().execute(model);
	}
	

}
