package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.admin.beans.DesignerDTO;
import com.admin.beans.AdminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adDesCreateCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		System.out.println(dto.getId());
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		int result = dao.insertDes(dto);
		int res = dao.grantDes(dto.getId(), "ROLE_DESIGNER");
		System.out.println(res);
		model.addAttribute("result", result);

	}

}
