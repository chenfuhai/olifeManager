package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class DiscOperationAction extends ActionSupport{
	private String discId;
	private String sharedMessageId; 
    private String userId;
    private String userImgUrl;
    private String username;
    private Boolean usersex;
    private String userage;   
    private String message;
    private String sql;
    
 
	public String Disc_show(){
		sql="select * from onekeySharedDisc";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
		}
		return null; 
	}
	
	public String Disc_dalete(){
		sql="delete from onekeySharedDisc where discId = '" + discId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
		}
		return null;
	}
}
