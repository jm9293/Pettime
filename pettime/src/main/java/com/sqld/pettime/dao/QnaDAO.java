package com.sqld.pettime.dao;

import java.util.List;

import com.sqld.pettime.dto.QnaDTO;

public interface QnaDAO {
	List<QnaDTO> select();
	List<QnaDTO> selectPage(int pageNum);
	int maxCnt();
	List<QnaDTO> selectPageBySearch(int pageNum, String val);
	int maxCntBySearch(String val);
	QnaDTO selectByUid(int num);
	int addViewCnt(int num);
}
