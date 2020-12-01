package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.AjaxAdmin;
import com.admin.beans.adResAjaxDAO;
import com.admin.beans.adminResDTO;
import com.sqld.pettime.util.DBSession;

public class adResReadlistCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		
		adResAjaxDAO dao = DBSession.sqlSession.getMapper(adResAjaxDAO.class);
		
		String date = (String)model.getAttribute("date");
		
		List<adminResDTO> list = dao.readRes(date);
		
		String status = "FAIL";
		
		if(list != null) {
			status = "OK";
		}
		
		AjaxAdmin data = new AjaxAdmin(status, list.size() , list);
		
		model.addAttribute("data", data);
		
		
	}

}
