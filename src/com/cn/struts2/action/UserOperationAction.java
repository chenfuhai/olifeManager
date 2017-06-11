package com.cn.struts2.action;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;
public class UserOperationAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	
	public String user_show(){
		sql="select * from ouser";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
		}
		return null; 
	}
	public String user_dalete(){
		//sql="delete from ouser where userid = '" + userId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
		}
		return null;
	}
	
	public String user_update(){
//		sql="update ouser set username = '"+userName+"'and userpwd = '"+userPwd+"'and phoneNum = '"+phoneNum+"'and sex = '"+sex+"'"
//				+ "and imgUrl = '"+imgUrl+"'and email = '"+email+"'and brithday = '"+brithday+"'where userid = '"+userId+"'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
		}
		return null;
	}
}
