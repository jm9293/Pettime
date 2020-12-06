package com.sqld.pettime.designer.command;


import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.DesMainDAO;
import com.sqld.pettime.dto.ResListDTO;
import com.sqld.pettime.util.DBSession;

public class DesMainCommand implements DCommand {

	@Override
	public void execute(Model model) {
		DesMainDAO dao = DBSession.sqlSession.getMapper(DesMainDAO.class);
		String id = (String)model.getAttribute("id");
		String datestr = (String)model.getAttribute("datestr");
		
		List<ResListDTO> list = dao.selectRes(id, datestr);
		model.addAttribute("list", list);
		model.addAttribute("datestr", datestr);
		model.addAttribute("id", id);
	}

}
