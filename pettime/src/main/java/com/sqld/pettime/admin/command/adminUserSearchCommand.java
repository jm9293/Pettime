package com.sqld.pettime.admin.command;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.UserDTO;
import com.admin.beans.adminInfoDAO;
import com.sqld.pettime.util.DBSession;

public class adminUserSearchCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		
		adminInfoDAO dao =  DBSession.sqlSession.getMapper(adminInfoDAO.class);
		List<UserDTO> list = null;
		List<UserDTO> list2 = new ArrayList<UserDTO>();
		Map<String, Object> map = model.asMap();
		String [] selectMenu = (String[])map.get("selectMenu");
		String text = (String)map.get("text");
		
		list = dao.selectUserlist();
		
		for (int i = 0; i < list.size(); i++) {
			if(selectMenu[0].toString().equals("id_sch") && (list.get(i).getId().equals(text) || list.get(i).getId().contains(text))) {
				list2.add(list.get(i));
			}else if(selectMenu[0].toString().equals("name_sch") && (list.get(i).getName().equals(text) || list.get(i).getName().contains(text))) {
				list2.add(list.get(i));
			}
		}
		list = list2;
		
		model.addAttribute("list", list);
		model.addAttribute("text", text);
		model.addAttribute("selectMenu", selectMenu);

	}

}
