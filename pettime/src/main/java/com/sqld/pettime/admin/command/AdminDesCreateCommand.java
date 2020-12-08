package com.sqld.pettime.admin.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;
import com.sqld.pettime.util.DefaultImgSet;

public class AdminDesCreateCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		DesignerDTO dto = (DesignerDTO)model.getAttribute("dto");
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		dto.setPassword(DBSession.passwordEncoder.encode(dto.getPassword()));
		HttpServletRequest request = (HttpServletRequest)model.getAttribute("request");
		
		int result = dao.insertDes(dto);
		int res = dao.grantDes(dto.getId(), "ROLE_DESIGNER");
		model.addAttribute("result", result);
		DefaultImgSet.imgSet(request, "designerimg", dto.getId());

	}

}
