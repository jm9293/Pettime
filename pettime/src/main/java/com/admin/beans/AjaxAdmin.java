package com.admin.beans;

import java.util.List;

public class AjaxAdmin {
	
	String status;
	
	int cnt;
	
	List data;
	
	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	public AjaxAdmin(String status, int cnt, List list) {
		super();
		this.status = status;
		this.cnt = cnt;
		this.data =list;
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

	@Override
	public String toString() {
		return "AjaxAdmin [status=" + status + ", cnt=" + cnt + ", data=" + data + "]";
	}
	
	

	
	

}
