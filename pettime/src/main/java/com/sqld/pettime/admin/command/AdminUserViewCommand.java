package com.sqld.pettime.admin.command;

import java.util.List;

import java.util.Map;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.util.DBSession;

public class AdminUserViewCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int userNum = (Integer)map.get("userNum");
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);

		List<UserDTO> list = dao.selectUserByNum(userNum);
		
		model.addAttribute("list", list);

	}

}
