package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.AjaxAdmin;
import com.admin.beans.AdResAjaxDAO;
import com.admin.beans.AdminResDTO;
import com.sqld.pettime.util.DBSession;

public class adResReadlistCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		
		AdResAjaxDAO dao = DBSession.sqlSession.getMapper(AdResAjaxDAO.class);
		
		String date = (String)model.getAttribute("date");
		
		List<AdminResDTO> list = dao.readRes(date);
		
		String status = "FAIL";
		
		if(list != null) {
			status = "OK";
		}
		
		AjaxAdmin data = new AjaxAdmin(status, list.size() , list);
		
		model.addAttribute("data", data);
		
		
	}

}
