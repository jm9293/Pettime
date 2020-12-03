package com.sqld.pettime.dao;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.sqld.pettime.dto.AdminMainDTO;

@MapperScan
public interface AdminMainDAO {
	public int selectRes();
	public int selectUser();
	public List<AdminMainDTO> worklist();
}
