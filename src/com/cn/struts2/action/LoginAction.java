package com.cn.struts2.action;

import java.io.PrintWriter;
import java.sql.ResultSet;

import java.sql.SQLException;



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

		if(username==null || username.equals("")){
			return "failed";
		}else if(userpwd == null || userpwd.equals("")){
			return "failed";
		}
		sql="select * from adminUser where username='"+username+"' and password = '"+userpwd+"'";
		System.out.println(sql);
		ResultSet resultSet =  new DBOpreate().executeQuery(sql);
		
		
		try {
			if(resultSet.next()){
				request.getSession().setAttribute("userName", username);
				return SUCCESS;
			}else{
				return "failed";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";

		
	

	}
	
}
