package com.cn.struts2.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;


import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class LoginAction extends ActionSupport{

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;

	public String execute(){

		String username = request.getParameter("");
		String userpwd = request.getParameter("");
		sql="select * from ouser where ='"+username+"' and userpwd = '"+userpwd+"'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			return SUCCESS;
		}else{
			return null;
		}
	}
	
}
