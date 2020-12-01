package com.admin.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.admin.beans.adminDesDTO;
import com.admin.beans.adminInfoDAO;
import com.admin.common.C;

public class adDesCreateIdChkCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		ArrayList<String> idList = new ArrayList<String>();

		adminInfoDAO dao = C.sqlSession.getMapper(adminInfoDAO.class);

		for (adminDesDTO dto : dao.selectDeslist()) {
			idList.add(dto.getId());
			model.addAttribute("idList", idList);
		}

	}

}
