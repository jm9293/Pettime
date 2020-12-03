package com.sqld.pettime.dto;

import java.sql.Date;

//공지사항 
public class NoticeDTO {
	
 public NoticeDTO() {
	
 }	

 public NoticeDTO(Integer num, String title, String content, Integer viewcnt, Date wrdate) {
		super();
		this.num = num;
		this.title = title;
		this.content = content;
		this.viewcnt = viewcnt;
		this.wrdate = wrdate;
	}

// 식별번호 
 private Integer num;

 // 제목 
 private String title;

 // 내용 
 private String content;

 // 조회수 
 private Integer viewcnt;

 // 작성일 
 private Date wrdate;

 public Integer getNum() {
     return num;
 }

 public void setNum(Integer num) {
     this.num = num;
 }

 public String getTitle() {
     return title;
 }

 public void setTitle(String title) {
     this.title = title;
 }

 public String getContent() {
     return content;
 }

 public void setContent(String content) {
     this.content = content;
 }

 public Integer getViewcnt() {
     return viewcnt;
 }

 public void setViewcnt(Integer viewcnt) {
     this.viewcnt = viewcnt;
 }

 public Date getWrdate() {
     return wrdate;
 }

 public void setWrdate(Date wrdate) {
     this.wrdate = wrdate;
 }

@Override
public String toString() {
	return "NoticeDTO [num=" + num + ", title=" + title + ", content=" + content + ", viewcnt=" + viewcnt + ", wrdate="
			+ wrdate + "]";
}

 

}
