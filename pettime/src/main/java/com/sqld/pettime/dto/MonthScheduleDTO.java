package com.sqld.pettime.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class MonthScheduleDTO {
	
	private int num;
	private String degId;
	private Date holiday;
}
