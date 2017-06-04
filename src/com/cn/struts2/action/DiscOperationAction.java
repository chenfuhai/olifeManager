package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class DiscOperationAction extends ActionSupport{
	private String discId;
	private String sharedMessageId; //分享结果ID
    private String userId;
    private String userImgUrl;
    private String username;
    private Boolean usersex;
    private String userage;   
    private String message;//评论内容
    private String sql;
    
    /**
	 * 显示
	 */
	public String Disc_show(){
		sql="select * from onekeySharedDisc";
		ResultSet flag = DBOpreate.executeQuery(sql);
		if(flag != null){
			//执行具体操作
		}
		return null; 
	}
	/**
	 * 删除
	 */
	public String Disc_dalete(){
		sql="delete from onekeySharedDisc where discId = '" + discId + "'";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			//执行具体操作
		}
		return null;
	}
}
