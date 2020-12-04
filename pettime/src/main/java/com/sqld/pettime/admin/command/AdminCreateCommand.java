package com.sqld.pettime.admin.command;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.AdminDTO;
import com.sqld.pettime.util.DBSession;

public class AdminCreateCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		AdminDTO dto = (AdminDTO)model.getAttribute("dto");
		dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));
		int result = dao.insertAdmin(dto);
		int res = dao.grantAdmin(dto.getId(), "ROLE_ADMIN");
		
		
		model.addAttribute("result", result);
	}

}
