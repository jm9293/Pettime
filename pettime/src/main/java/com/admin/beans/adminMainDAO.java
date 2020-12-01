package com.admin.beans;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface adminMainDAO {
	public int selectRes();
	public int selectUser();
}
