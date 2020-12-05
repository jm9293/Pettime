package com.sqld.pettime.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class DayscheduleDTO {
	
	private int num;
	private String degId;
	private Date day;
	private int time1;
	private int time2;
	private int time3;
	
}
