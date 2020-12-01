package com.sqld.pettime.admin.command;


import org.springframework.ui.Model;
import com.admin.beans.AjaxAdmin;
import com.admin.beans.AdminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adDesCreateIdChkCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		String id = (String) model.getAttribute("id");

		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);

		int cnt = dao.idChk(id);
		String status = "FAIL";

		if(id != null) {
			status = "OK";
		}

		AjaxAdmin data = new AjaxAdmin(status, cnt, null);

		model.addAttribute("data", data);
	}

}
