package com.sqld.pettime.user.command;



import java.util.List;

import org.springframework.ui.Model;

import com.admin.beans.QnaDAO;
import com.admin.beans.QnaDTO;
import com.admin.beans.UserAJAX;
import com.sqld.pettime.util.DBSession;

public class UserQnASelectCommend implements UserCommand{

	@Override
	public void excute(Model model) {
		List<QnaDTO> list = null;
		UserAJAX ajax = new UserAJAX();
		
		QnaDAO dao = DBSession.sqlSession.getMapper(QnaDAO.class);
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
