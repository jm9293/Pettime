package com.sqld.pettime.admin.command;

import java.util.List;

import java.util.Map;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.DesignerDTO;
import com.sqld.pettime.util.DBSession;

public class adminDesViewCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);

		List<DesignerDTO> list = dao.selectDesByNum(num);
		model.addAttribute("list", list);

	}

}
