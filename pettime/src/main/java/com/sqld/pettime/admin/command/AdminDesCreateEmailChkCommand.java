package com.sqld.pettime.admin.command;


import org.springframework.ui.Model;

import com.sqld.pettime.admin.beans.AjaxAdmin;
import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class AdminDesCreateEmailChkCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		String emailId = (String) model.getAttribute("emailId");
		StringBuffer emailAdd = (StringBuffer) model.getAttribute("emailAdd");
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		emailAdd.insert(emailAdd.lastIndexOf("c"), ".");
		String email = emailId + "@" + emailAdd;
		int cnt = dao.emailChk(email);
		
		String status = "FAIL";

		if(email != null) {
			status = "OK";
		}

		AjaxAdmin data = new AjaxAdmin(status, cnt, null);

		model.addAttribute("data", data);
	}

}
