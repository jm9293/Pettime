package com.sqld.pettime.user.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.dao.QnaDAO;
import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.dto.QnaDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserQnAWriteCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<QnaDTO> list = new ArrayList<QnaDTO>();
		UserDataJSON ajax = new UserDataJSON();
		QnaDTO dto = (QnaDTO)model.getAttribute("dto");
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		
		
		System.out.println(dto);
		int res = dao.insert(dto);
		
		
		if(res==0) {
			ajax.setStatus("NO");
			ajax.setCnt(0);
			ajax.setData(null);
		}else {
			ajax.setStatus("OK");
			ajax.setCnt(res);
			list.add(dto);
			ajax.setData(list);
		}
		
		model.addAttribute("ajax", ajax);

	}

}
