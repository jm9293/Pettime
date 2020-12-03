package com.sqld.pettime.user.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.dao.NoticeDAO;
import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.user.beans.UserDataJSON;
import com.sqld.pettime.util.DBSession;

public class UserNoticeSelectCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<NoticeDTO> list = null;
		UserDataJSON ajax = new UserDataJSON();
		
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		int maxCnt = dao.maxCnt();
		list = dao.selectPage((int)model.getAttribute("pageNum"));
		
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
