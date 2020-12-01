package com.sqld.pettime.admin.command;

import java.util.ArrayList;


import org.springframework.ui.Model;

import com.admin.beans.DesignerDTO;
import com.admin.beans.adminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adDesCreateIdChkCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		ArrayList<String> idList = new ArrayList<String>();

		adminInfoDAO dao = DBSession.sqlSession.getMapper(adminInfoDAO.class);

		for (DesignerDTO dto : dao.selectDeslist()) {
			idList.add(dto.getId());
			model.addAttribute("idList", idList);
		}

	}

}
