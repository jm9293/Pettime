package com.sqld.pettime.admin.command;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;

import com.sqld.pettime.admin.beans.AjaxAdmin;
import com.sqld.pettime.dao.AdResAjaxDAO;
import com.sqld.pettime.dto.AdminResDTO;
import com.sqld.pettime.util.DBSession;


public class adResDeleteCommand implements adminCommand {

	@Override
	public void execute(Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		int cnt = 0;
		AdResAjaxDAO dao = DBSession.sqlSession.getMapper(AdResAjaxDAO.class);
		
		int [] nums = (int[])model.getAttribute("nums");
		List<AdminResDTO> list = new ArrayList<AdminResDTO>();
		for (int i = 0; i < nums.length; i++) {
			list.add(dao.searchRes(nums[i]));
			System.out.println("들어옴?1");
		}
		
		for (int i = 0; i < list.size(); i++) {
			String degId = list.get(i).getDegid();
			String stime = sdf.format(list.get(i).getStime());
			System.out.println(stime);
			int time = list.get(i).getStime().getHours();
			
			if(time == 9) {
				dao.updateListA(degId, stime);
			}else if(time == 13) {
				dao.updateListB(degId, stime);
			}else if(time == 16) {
				dao.updateListC(degId, stime);
			}
			System.out.println("들어옴?2");
			
		}
		
		String status = "FAIL";
		
		if(nums != null) {
			cnt = dao.deleteList(nums);
			status = "OK";
			System.out.println("들어옴?3");
		}
		
		AjaxAdmin data = new AjaxAdmin(status, cnt, null);
		
		model.addAttribute("data", data);
	}

}
