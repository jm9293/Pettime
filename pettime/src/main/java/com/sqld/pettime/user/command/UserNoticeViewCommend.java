package com.sqld.pettime.user.command;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.NoticeDAO;
import com.admin.beans.NoticeDTO;
import com.admin.beans.UserAJAX;
import com.sqld.pettime.util.DBSession;

public class UserNoticeViewCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<NoticeDTO> list = null;
		UserAJAX ajax = new UserAJAX();
		
		NoticeDAO dao = DBSession.sqlSession.getMapper(NoticeDAO.class);
		int uid = (int)model.getAttribute("uid");
		list = new ArrayList<NoticeDTO>();
		
		dao.addViewCnt(uid);	
		NoticeDTO notice = dao.selectByUid(uid);
		
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
