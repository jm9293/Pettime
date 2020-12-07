package com.sqld.pettime.user.command;


import java.util.List;
import org.springframework.ui.Model;

import com.sqld.pettime.dao.MenuDAO;
import com.sqld.pettime.dao.ResListDAO;

import com.sqld.pettime.dto.DesignerDTO;

import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserCallDesignersCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<DesignerDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		String date = (String)model.getAttribute("date");
		String time = (String)model.getAttribute("time");
		
		ResListDAO dao = DBSession.sqlSession.getMapper(ResListDAO.class);
		MenuDAO dao2 = DBSession.sqlSession.getMapper(MenuDAO.class);
		switch (time) {
		case "time1":
			list = dao.callDesignersA(date);
			break;
		case "time2":
			list = dao.callDesignersB(date);
			break;
		case "time3":
			list = dao.callDesignersC(date);
			break;

		}
		
		if(list!=null) {
			for (DesignerDTO designerDTO : list) { //데이터가공
				designerDTO.setEmail("");
				designerDTO.setEnabled('0');
				designerDTO.setNum(0);
				designerDTO.setPassword("");
				designerDTO.setPhone("");
			}
		}
		
			
		
		if(list==null) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			ajax.setData(null);
		}else {
			ajax.setStatus("OK");
			ajax.setCnt(list.size());
			ajax.setData(list);
			ajax.setData2(dao2.selectList());
		}
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
