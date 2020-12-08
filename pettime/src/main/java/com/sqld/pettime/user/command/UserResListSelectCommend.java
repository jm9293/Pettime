package com.sqld.pettime.user.command;



import java.util.List;

import org.springframework.ui.Model;


import com.sqld.pettime.dao.ResListDAO;

import com.sqld.pettime.dto.ResListDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserResListSelectCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<ResListDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		String id = (String)model.getAttribute("id");
		ResListDAO dao = DBSession.sqlSession.getMapper(ResListDAO.class);
		int maxCnt = dao.maxCnt(id);
		list = dao.selectPage((int)model.getAttribute("pageNum"), id);
		
		if(list ==null) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			ajax.setData(null);
		}else {
			ajax.setStatus("OK");
			ajax.setCnt(list.size());
			ajax.setData(list);
			ajax.setMaxpage((int)Math.ceil(maxCnt/7.0)); 
		}
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
