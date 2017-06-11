package com.cn.struts2.action;

import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;


public class ShareOperationAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	
	public String Share_show(){
		sql="select * from onekeySharedMessage";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
		
		}
		return null; 
	}
	
	
	public String Share_dalete(){
		//sql="delete from onekeySharedMessage where messageid = '" + messageId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			
		}
		return null;
	}	
	
	public String Share_update(){
//		sql="update onekeySharedMessage set resultMark = '"+resultMark+"'and ben = '"+ben+"'and pm2_5 = '"+pm2_5+"'and suggest = '"+suggest+"'"
//				+ "and ing = '"+lng+"'and lat = '"+lat+"'and province = '"+province+"'"
//						+ "and district = '"+district+"'and city = '"+city+"'and street = '"+street+"'"
//								+ "and streetNum = '"+StreetNum+"'where messageid = '"+messageId+"'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			
		}
		return null;
	}
}
