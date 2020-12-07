package com.sqld.pettime.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sqld.pettime.dto.ResDetailDTO;
import com.sqld.pettime.dto.ResListDTO;

@MapperScan
public interface DesMainDAO {
	public ResListDTO selectResNum(int num, String id);
	public List<ResListDTO> selectRes(String id, String date);
	public List<ResDetailDTO> searchDetail(int num);
	public int updateResult(int num, String state);
	public int updateReset(int num, String state);
}
