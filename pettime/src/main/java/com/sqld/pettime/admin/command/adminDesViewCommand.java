package com.sqld.pettime.admin.command;

import java.util.List;

import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.DesignerDTO;
import com.admin.beans.adminInfoDAO;

import com.sqld.pettime.util.DBSession;

public class adminDesViewCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		adminInfoDAO dao = DBSession.sqlSession.getMapper(adminInfoDAO.class);

		List<DesignerDTO> list = dao.selectDesByNum(num);
		model.addAttribute("list", list);

	}

}
