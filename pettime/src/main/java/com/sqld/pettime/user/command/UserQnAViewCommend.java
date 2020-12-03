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

public class UserQnAViewCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<QnaDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
		int uid = (int)model.getAttribute("uid");
		list = new ArrayList<QnaDTO>();
		
		dao.addViewCnt(uid);	
		QnaDTO notice = dao.selectByUid(uid);
		
		if(notice!=null) {
			list.add(notice);
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
