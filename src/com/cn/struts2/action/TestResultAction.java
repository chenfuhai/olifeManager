package com.cn.struts2.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeyResultRecord;
import utils.DBOpreate;

public class TestResultAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	
	public String TestResult_show(){
		sql="select * from onekeyResultRecord";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		ArrayList<OnekeyResultRecord> list = new ArrayList<>();
		try {
			while(result.next()){
				OnekeyResultRecord record = new OnekeyResultRecord();
				//record.
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}

	public String TestResult_dalete(){
		//sql="delete from onekeyResultRecord where recordId = '" + recordId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
		}
		return null;
	}
}
