package com.sqld.pettime.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AdminResDTO {
	
	private int num;
	private Timestamp stime;
	private Timestamp etime;
	private String address;
	private String userid;
	private String degid;
	private int petnum;
	private int tprice;
	private String state;

}
