package com.sqld.pettime.admin.command;

import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.AdminDTO;
import com.sqld.pettime.util.DBSession;

public class AdminShowListCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		List<AdminDTO> list = dao.selectAdmin();
		
		model.addAttribute("list", list);
	}

}
