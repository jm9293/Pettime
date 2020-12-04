package com.sqld.pettime.user.beans;

import java.util.List;

public class UserDataJSON {
String status;
	
	int cnt;
	
	List data;
	
	int maxpage;
		
	public UserDataJSON() {
		
	}
	 

	public int getMaxpage() {
		return maxpage;
	}


	public void setMaxpage(int maxpage) {
		this.maxpage = maxpage;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}
	
	
	
}
