package com.sqld.pettime.user.controller;




import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.admin.beans.UserAJAX;
import com.sqld.pettime.user.command.UserNoticeSelectCommend;
import com.sqld.pettime.user.command.UserNoticeViewCommend;




@RestController
@RequestMapping("/rest")
public class UserRestController {
	
	@RequestMapping("/notice/list/{pageNum}")
	UserAJAX NoiceSelect(Model model, @PathVariable int pageNum) {
		model.addAttribute("pageNum", pageNum);
		new UserNoticeSelectCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");
		
		return ajax;
	}
	
	@RequestMapping("/notice/view/{uid}")
	UserAJAX NoiceView(Model model, @PathVariable int uid) {
		model.addAttribute("uid", uid);
		
		new UserNoticeViewCommend().excute(model);
		
		UserAJAX ajax = (UserAJAX) model.getAttribute("ajax");
		
		return ajax;
	}
	

}
