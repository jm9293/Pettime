package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;

public class AdminDesCreateCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));
		int result = dao.insertDes(dto);
		int res = dao.grantDes(dto.getId(), "ROLE_DESIGNER");
		System.out.println(res);
		model.addAttribute("result", result);

	}

}
