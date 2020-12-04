package com.sqld.pettime.user.command;


import org.springframework.ui.Model;


import com.sqld.pettime.dao.UserDAO;

import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserEmailchkCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		
		UserDataJSON ajax = new UserDataJSON();
		String email = (String)model.getAttribute("email");
		UserDAO dao = DBSession.sqlSession.getMapper(UserDAO.class);

		int res = dao.emailchk(email);
		
		
		if(res==0) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			
		}else {
			ajax.setStatus("OK");
			ajax.setCnt(res);
		}
		
		model.addAttribute("ajax", ajax);

	}

}
