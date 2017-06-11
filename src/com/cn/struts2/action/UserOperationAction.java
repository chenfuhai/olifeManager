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

import entity.User;
import utils.DBOpreate;
public class UserOperationAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	
	public String user_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from ouser";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		ArrayList<User> userData = new ArrayList<>();
		try {
			while(result.next()){
				User user = new User();
				user.setId(result.getInt("id"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("userpwd"));
				user.setEmail(result.getString("email"));
				user.setImgUrl(result.getString("imgUrl"));
				user.setPhone(result.getString("phone"));
				user.setSex(result.getString("sex"));
				user.setAge(result.getString("age"));
				user.setBrithday(result.getString("brithday"));
				userData.add(user);
			}
			String data = gson.toJson(userData);
			try {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println(data);
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
	
	public String user_update(){
		String userId = request.getParameter("");
		String username = request.getParameter("");
		String userpwd = request.getParameter("");
		String userphone = request.getParameter("");
		String usersex = request.getParameter("");
		String userimgUrl = request.getParameter("");
		String userbrithday = request.getParameter("");
		String useremail = request.getParameter("");
		String userage = request.getParameter("");
		
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
		String sb14= new String();
		String sb15 = new String();
		String sb16= new String();
		
		if (username != null) {
			sb1="username=";
			sb2="'" + username + "',";
		}
		if (userpwd != null) {
			sb3="userpwd=";
			sb4="'" + userpwd + "',";
		}
		if (userphone != null) {
			sb5="phone=";
			sb6="'" + userphone + "',";
		}
		if (usersex != null) {
			sb7="sex=";
			sb8="'" + usersex + "',";
		}
		if (userbrithday != null) {
			sb9="brithday=";
			sb10="'" + userbrithday + "',";
		}
		if (useremail != null) {
			sb11="email=";
			sb12="'" + useremail + "',";
		}
		if (userimgUrl != null) {
			sb13="imgUrl=";
			sb14="'" + userimgUrl + "',";
		}
		if(userage!=null){
			sb15="age=";
			sb16="'" + userage + "',";
		}
		
		sql = "select * from ouser where username = "+username;
		ResultSet flag = new DBOpreate().executeQuery(sql);
		if(flag == null){
			//存在当前用户名
			return ERROR;
		}else{
			String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+""+sb9+""+sb10+""+sb11+""+sb12+""+sb13+""+sb14+""+sb15+""+sb16;
			String result = sresult.substring(0, sresult.length()-1);
			sql = "update ouser set "+result+" where id = "+userId;
			System.out.println(sql);
			boolean flag2 =  new DBOpreate().execute(sql);
			if(flag2 == true){
				return SUCCESS;
			}
		}
		
		return null;
	}
}
