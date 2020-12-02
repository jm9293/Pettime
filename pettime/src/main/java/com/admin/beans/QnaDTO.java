package com.admin.beans;

import java.sql.Date;

//묻고 답하기 
public class QnaDTO {

 // 식별번호 
 private Integer num;

 // 작성자 
 private String userid;

 // 제목 
 private String title;

 // 내용 
 private String content;

 // 조회수 
 private Integer viewcnt;

 // 작성일 
 private Date wrdate;

 // 답변 
 private String anser;

 // 답변일 
 private Date andate;

 // 공개여부 
 private String open;

 public Integer getNum() {
     return num;
 }

 public void setNum(Integer num) {
     this.num = num;
 }

 public String getUserid() {
     return userid;
 }

 public void setUserid(String userid) {
     this.userid = userid;
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

 public String getAnser() {
     return anser;
 }

 public void setAnser(String anser) {
     this.anser = anser;
 }

 public Date getAndate() {
     return andate;
 }

 public void setAndate(Date andate) {
     this.andate = andate;
 }

 public String getOpen() {
     return open;
 }

 public void setOpen(String open) {
     this.open = open;
 }


}
