package com.admin.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.adminInfoDAO;
import com.admin.beans.adminUserDTO;
import com.admin.common.C;

public class adminUserViewCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int userNum = (Integer)map.get("userNum");
		adminInfoDAO dao = C.sqlSession.getMapper(adminInfoDAO.class);

		List<adminUserDTO> list = dao.selectUserByNum(userNum);
		
		model.addAttribute("list", list);

	}

}
