package com.sqld.pettime.dao;

import java.util.List;



import org.mybatis.spring.annotation.MapperScan;


import com.sqld.pettime.dto.ResDetailDTO;

@MapperScan
public interface ResDetailDAO {
	
	int insert(ResDetailDTO dto);
	
	List<ResDetailDTO> searchDetail(int num);
	
}
