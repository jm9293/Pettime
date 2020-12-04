package com.sqld.pettime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sqld.pettime.dto.NoticeDTO;
import com.sqld.pettime.dto.QnaDTO;

public interface NoticeDAO {
	List<NoticeDTO> select();
	List<NoticeDTO> selectPage(int pageNum);
	int maxCnt();
	NoticeDTO selectByUid(int num);
	int addViewCnt(int num);
	public int writeNotice(@Param("a") NoticeDTO dto);
	public int updateNotice(@Param("a") NoticeDTO dto);
	List<NoticeDTO> selectPageBySearch(int page, String title);
	int maxCntBySearch(String title);
	public int deleteNum(int num);
}
