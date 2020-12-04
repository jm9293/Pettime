package com.sqld.pettime.admin.command;

import java.util.List;


import org.springframework.ui.Model;

import com.sqld.pettime.dao.AdminInfoDAO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.util.DBSession;

public class AdmindUserStatusCommand implements AdminCommand {

	@Override
	public void execute(Model model) {
		AdminInfoDAO dao = DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		int num = (int)model.getAttribute("num");
		char chk = '1';
		char chk2 = '0';
		int cnt = 0;
		UserDTO dto = new UserDTO();
		
		List<UserDTO> list = dao.selectUserByNum(num);
		
		for (int i = 0; i < list.size(); i++) {
			dto.setUserNum(list.get(i).getUserNum());
			dto.setId(list.get(i).getId());
			dto.setName(list.get(i).getName());
			dto.setEmail(list.get(i).getEmail());
			dto.setPhone(list.get(i).getPhone());
			dto.setEnabled(list.get(i).getEnabled());
		}
		
		if(dto.getEnabled() == chk) {
			dto.setEnabled(chk2);
		}else {
			dto.setEnabled(chk);
		}
		
		cnt = dao.updateUserInfo(dto.getUserNum(), dto);
		
		model.addAttribute("cnt", cnt);
		model.addAttribute("userNum", dto.getUserNum());
	}

}
