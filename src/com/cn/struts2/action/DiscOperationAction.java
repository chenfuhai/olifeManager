package com.cn.struts2.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeySharedDisc;
import utils.DBOpreate;

public class DiscOperationAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
    ArrayList<OnekeySharedDisc> discs;
 
	public String Disc_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from onekeySharedDisc";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		try {
			while(result.next()){
				OnekeySharedDisc disc = new OnekeySharedDisc();
				disc.setId(result.getInt("id"));
				disc.setMessage(result.getString("discmessage"));
				disc.setSharedMessageId(result.getInt("sharedMessageId"));
				disc.setUserage(result.getString("userage"));
				disc.setUserId(result.getString("userid"));
				disc.setUserImgUrl(result.getString("userimgUrl"));
				disc.setUsername(result.getString("username"));
				discs.add(disc);
			}
			String data = gson.toJson(discs);
			try {
				response.getWriter().print(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	
}
