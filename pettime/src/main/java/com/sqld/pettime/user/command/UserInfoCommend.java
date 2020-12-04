package com.sqld.pettime.user.command;

import java.util.ArrayList;
import java.util.List;
import org.springframework.ui.Model;
import com.sqld.pettime.dao.UserDAO;
import com.sqld.pettime.dto.UserDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserInfoCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<UserDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		
		UserDAO dao = DBSession.sqlSession.getMapper(UserDAO.class);
		String id= (String)model.getAttribute("id");
		list = new ArrayList<UserDTO>();
		
		
		UserDTO dto = dao.selectById(id);
		
		if(dto!=null) {
			list.add(dto);
		}
		
		if(list.isEmpty()) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			ajax.setData(null);
		}else {
			ajax.setStatus("OK");
			ajax.setCnt(list.size());
			ajax.setData(list);
		}
		
		
		model.addAttribute("ajax", ajax);
		
		
		
	}

}
