package com.sqld.pettime.admin.command;

import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.admin.beans.DesignerDTO;
import com.admin.beans.AdminInfoDAO;

import com.sqld.pettime.util.DBSession;

public class adminDesSearchCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		
		AdminInfoDAO dao =  DBSession.sqlSession.getMapper(AdminInfoDAO.class);
		List<DesignerDTO> list = null;
		List<DesignerDTO> list2 = new ArrayList<DesignerDTO>();
		Map<String, Object> map = model.asMap();
		String [] selectMenu = (String[])map.get("selectMenu");
		String text = (String)map.get("text");
		String select = selectMenu[0];
		list = dao.selectDeslist();
		
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
		model.addAttribute("select", select);

	}

}
