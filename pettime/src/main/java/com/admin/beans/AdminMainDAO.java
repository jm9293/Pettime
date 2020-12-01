package com.admin.beans;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface AdminMainDAO {
	public int selectRes();
	public int selectUser();
}
