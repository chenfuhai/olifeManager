package com.cn.struts2.action;

import java.io.PrintWriter;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class LoginAction extends ActionSupport{
	private String userId;
	private String userPwd;
	private String sql;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	public String execute(){
		sql="select * from ouser where userid='"+userId+"' and userpwd = '"+userPwd+"'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			return null;
		}
		return null;
		
	}
	
}
