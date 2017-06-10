package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class FeedbackOperationAction extends ActionSupport{
	private String feedbackId;
    private String userName;
    private String userAge;
    private String userSex;
    private String feedbackMsg;
    private String qq;
    private String email;
    private String phone;
    private String sql;
	public String getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(String feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserAge() {
		return userAge;
	}
	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getFeedbackMsg() {
		return feedbackMsg;
	}
	public void setFeedbackMsg(String feedbackMsg) {
		this.feedbackMsg = feedbackMsg;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
	
	public String user_show(){
		sql="select * from feedback";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
		
		}
		return null;
	}
	
	public String user_dalete(){
		sql="delete from feedback where feedbackid = '" + feedbackId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			
		}
		return null;
	}
}
