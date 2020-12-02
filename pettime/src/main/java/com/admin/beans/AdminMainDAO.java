package com.admin.beans;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AdminMainDAO {
	public int selectRes();
	public int selectUser();
	public List<AdminMainDTO> worklist();
}
