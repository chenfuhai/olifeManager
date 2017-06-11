package com.cn.struts2.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class LoginAction extends ActionSupport{
	
	
	public String execute(){
		HttpServletRequest request  =ServletActionContext.getRequest();
		System.out.println(request.getParameter("username")+request.getParameter("password"));
		
		
		
		
		return SUCCESS;
		
	}
	
}
