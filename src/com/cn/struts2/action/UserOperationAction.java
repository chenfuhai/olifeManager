package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;
public class UserOperationAction extends ActionSupport{
	private String userId;
	private String userName;
	private String userPwd;
	private String phoneVe;
	private String phoneNum;
	private String sex;
	private String imgUrl;
	private String email;
	private String emailVe;
	private String brithday;
	private String sql;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getPhoneVe() {
		return phoneVe;
	}
	public void setPhoneVe(String phoneVe) {
		this.phoneVe = phoneVe;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmailVe() {
		return emailVe;
	}
	public void setEmailVe(String emailVe) {
		this.emailVe = emailVe;
	}
	public String getBrithday() {
		return brithday;
	}
	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}
	
	public String user_show(){
		sql="select * from ouser";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
		}
		return null; 
	}
	public String user_dalete(){
		sql="delete from ouser where userid = '" + userId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
		}
		return null;
	}
	
	public String user_update(){
		sql="update ouser set username = '"+userName+"'and userpwd = '"+userPwd+"'and phoneNum = '"+phoneNum+"'and sex = '"+sex+"'"
				+ "and imgUrl = '"+imgUrl+"'and email = '"+email+"'and brithday = '"+brithday+"'where userid = '"+userId+"'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
		}
		return null;
	}
}
