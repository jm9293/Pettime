package com.sqld.pettime.admin.command;

import java.util.List;

import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.UserDTO;
import com.admin.beans.AdminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adminUserViewCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int userNum = (Integer)map.get("userNum");
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);

		List<UserDTO> list = dao.selectUserByNum(userNum);
		
		model.addAttribute("list", list);

	}

}
