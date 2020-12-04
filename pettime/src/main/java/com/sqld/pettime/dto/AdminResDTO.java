package com.sqld.pettime.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AdminResDTO {
	
	private int num;
	private Timestamp stime;
	private String address;
	private String userid;
	private String degid;
	private String petName;
	private String petKind;
	private String petMemo;
	private int tprice;
	private String state;

}
