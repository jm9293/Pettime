package com.sqld.pettime.admin.command;

import java.util.List;

import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.UserDTO;
import com.admin.beans.adminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adminUserViewCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int userNum = (Integer)map.get("userNum");
		adminInfoDAO dao = DBSession.sqlSession.getMapper(adminInfoDAO.class);

		List<UserDTO> list = dao.selectUserByNum(userNum);
		
		model.addAttribute("list", list);

	}

}
