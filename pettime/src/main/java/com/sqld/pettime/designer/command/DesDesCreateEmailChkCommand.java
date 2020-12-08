package com.sqld.pettime.designer.command;


import org.springframework.ui.Model;
import com.sqld.pettime.dao.DesignerDAO;
import com.sqld.pettime.designer.beans.AjaxDes;
import com.sqld.pettime.util.DBSession;

public class DesDesCreateEmailChkCommand implements DCommand {

	@Override
	public void execute(Model model) {
		String emailId = (String) model.getAttribute("emailId");
		StringBuffer emailAdd = (StringBuffer) model.getAttribute("emailAdd");
		DesignerDAO dao = DBSession.sqlSession.getMapper(DesignerDAO.class);
		emailAdd.insert(emailAdd.lastIndexOf("c"), ".");
		String email = emailId + "@" + emailAdd;
		int cnt = dao.emailChk(email);
		
		String status = "FAIL";

		if(email != null) {
			status = "OK";
		}

		AjaxDes data = new AjaxDes(status, cnt, null);

		model.addAttribute("data", data);
	}

}
