package com.cn.struts2.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		ServletActionContext.getRequest().getSession().setAttribute("userName", null);
		return SUCCESS;
	}
}
