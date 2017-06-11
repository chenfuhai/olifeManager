package com.cn.struts2.action;

import java.io.PrintWriter;
import java.sql.ResultSet;

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

		String username = request.getParameter("username");
		String userpwd = request.getParameter("password");
		sql="select * from adminUser where ='"+username+"' and password = '"+userpwd+"'";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	
}
