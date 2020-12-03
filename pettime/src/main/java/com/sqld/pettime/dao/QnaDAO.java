package com.sqld.pettime.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sqld.pettime.dto.QnaDTO;

public interface QnaDAO {
	List<QnaDTO> select();
	List<QnaDTO> selectPage(int pageNum);
	int maxCnt();
	List<QnaDTO> selectPageBySearch(int pageNum, String val);
	int maxCntBySearch(String val);
	QnaDTO selectByUid(int num);
	int addViewCnt(int num);
	int insert(@Param("dto") QnaDTO dto);
	int update(@Param("dto") QnaDTO dto);
	int delete(@Param("dto") QnaDTO dto);
}
