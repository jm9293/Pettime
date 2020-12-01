package com.admin.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.adminDesDTO;
import com.admin.beans.adminInfoDAO;
import com.admin.beans.adminUserDTO;
import com.admin.common.C;

public class adminDesViewCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int num = (Integer)map.get("num");
		adminInfoDAO dao = C.sqlSession.getMapper(adminInfoDAO.class);

		List<adminDesDTO> list = dao.selectDesByNum(num);
		model.addAttribute("list", list);

	}

}
