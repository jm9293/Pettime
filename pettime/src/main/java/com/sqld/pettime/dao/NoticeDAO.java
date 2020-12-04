package com.sqld.pettime.dao;

import java.util.List;

import com.sqld.pettime.dto.NoticeDTO;

public interface NoticeDAO {
	List<NoticeDTO> select();
	List<NoticeDTO> selectPage(int pageNum);
	int maxCnt();
	NoticeDTO selectByUid(int num);
	int addViewCnt(int num);
}
