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

import entity.Goods;
import entity.OnekeySharedDisc;
import utils.DBOpreate;
import utils.NetUtils;

public class DiscOperationAction extends ActionSupport {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	ArrayList<OnekeySharedDisc> discs;

	public String disc_insert() {
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedDisc disc = gson.fromJson(msg, OnekeySharedDisc.class);
		System.out.println(msg);

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();

		if (disc.getSharedMessageId() != 0) {
			sb1.append("sharedMessageId").append(",");
			sb2.append("'" + disc.getSharedMessageId() + "'").append(",");
		}
		if (disc.getUserId() != null) {
			sb1.append("userid").append(",");
			sb2.append("'" + disc.getUserId() + "'").append(",");
		}
		if (disc.getUserImgUrl() != null) {
			sb1.append("userimgUrl").append(",");
			sb2.append("'" + disc.getUserImgUrl() + "'").append(",");
		}
		if (disc.getUsername() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + disc.getUsername() + "'").append(",");
		}
		if (disc.getUsersex() != null) {
			sb1.append("usersex").append(",");
			sb2.append("'" + disc.getUsersex() + "'").append(",");
		}
		if (disc.getUserage() != null) {
			sb1.append("userage").append(",");
			sb2.append("'" + disc.getUserage() + "'").append(",");
		}
		if (disc.getMessage() != null) {
			sb1.append("discmessage").append(",");
			sb2.append("'" + disc.getMessage() + "'").append(",");
		}

		String result1 = sb1.toString().substring(0, sb1.toString().length() - 1);
		String result2 = sb2.toString().substring(0, sb2.toString().length() - 1);

		sql = "insert into goods(" + result1 + ") values(" + result2 + ")";
		boolean flag = new DBOpreate().execute(sql);
		if (flag == true) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		return null;
	}

	public String Disc_show() {
		Gson gson = new GsonBuilder().create();
		sql = "select * from onekeySharedDisc order by id desc";
		ResultSet result = new DBOpreate().executeQuery(sql);
		try {
			while (result.next()) {
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
				response.setContentType("text/html;charset=UTF-8");
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
	
	public String disc_delete(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedDisc disc = gson.fromJson(msg, OnekeySharedDisc.class);
		System.out.println(msg);
		if(disc.getId()==0 || disc.getId()==-1){
			//do not execute the sql
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().print("failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}{
			//safe
			String sql = "delete onekeySharedDisc where id ="+disc.getId();
			boolean flag= new DBOpreate().execute(sql);
			if(flag){
				try {
					response.getWriter().print("success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					response.getWriter().print("failed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}
	public String disc_update(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedDisc disc = gson.fromJson(msg, OnekeySharedDisc.class);
		System.out.println(msg);
		
		String sb1 = new String();
		String sb2 = new String();
		String sb3 = new String();
		String sb4 = new String();
		String sb5 = new String();
		String sb6 = new String();
		String sb7 = new String();
		String sb8 = new String();
		String sb9 = new String();
		String sb10 = new String();
		String sb11 = new String();
		String sb12 = new String();
		String sb13 = new String();
		String sb14 = new String();
		
		if(disc.getSharedMessageId()!=0){
			sb1="sharedMessageId=";
			sb2="'" + disc.getSharedMessageId() + "',";
		}
		if(disc.getUserId()!=null){
			sb3="userid=";
			sb4="'" + disc.getUserId() + "',";
		}
		if(disc.getUserImgUrl()!=null){
			sb5="userimgUrl=";
			sb6="'" + disc.getUserImgUrl() + "',";
		}
		if(disc.getUsername()!=null){
			sb7="username=";
			sb8="'" + disc.getUsername() + "',";
		}
		if(disc.getUsersex()!=null){
			sb9="usersex=";
			sb10="'" + disc.getUsersex() + "',";
		}
		if(disc.getUserage()!=null){
			sb11="userage=";
			sb12="'" + disc.getUserage() + "',";
		}
		if(disc.getMessage()!=null){
			sb13="discmessage=";
			sb14="'" + disc.getMessage() + "',";
		}
		
		String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+"";
		String result = sresult.substring(0, sresult.length()-1);
		sql="select * from onekeySharedDisc where id = '"+disc.getId()+"'";
		ResultSet result1 = new DBOpreate().executeQuery(sql);
		try {

			if(!result1.next()){
				
				response.getWriter().print("failed");
				return null;
			}else{
				sql="update onekeySharedDisc set "+result+" where id = "+disc.getId();
				boolean flag2 =  new DBOpreate().execute(sql);
				System.out.println(sql+flag2);
				if(flag2 == true){
					response.getWriter().print("success");
					return null;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
		return null;
	}
}
