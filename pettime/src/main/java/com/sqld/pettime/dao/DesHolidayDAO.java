package com.sqld.pettime.dao;

import java.util.Date;
import java.util.List;

import com.sqld.pettime.dto.MonthScheduleDTO;

public interface DesHolidayDAO {
	public List<MonthScheduleDTO> selectHol(String id, Date date);
	public int chkHol(String id, Date date);
	public int addHol(String id, Date date);
	public int deleteHol(String id, Date date);
}
