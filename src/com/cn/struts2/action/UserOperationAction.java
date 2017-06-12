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
import entity.User;
import utils.DBOpreate;
import utils.NetUtils;
public class UserOperationAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	public String user_insert(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);
		System.out.println(msg);
		
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		if (user.getUsername() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + user.getUsername() + "'").append(",");
		}
		if (user.getPassword() != null) {
			sb1.append("userpwd").append(",");
			sb2.append("'" + user.getPassword() + "'").append(",");
		}
		if (user.getSex() != null) {
			sb1.append("sex").append(",");
			sb2.append("'" + user.getSex() + "'").append(",");
		}
		if (user.getImgUrl() != null) {
			sb1.append("imgUrl").append(",");
			sb2.append("'" + user.getImgUrl() + "'").append(",");
		}
		if (user.getBrithday() != null) {
			sb1.append("brithday").append(",");
			sb2.append("'" + user.getBrithday() + "'").append(",");
		}
		if (user.getEmail() != null) {
			sb1.append("email").append(",");
			sb2.append("'" + user.getEmail() + "'").append(",");
		}
		if (user.getPhone() != null) {
			sb1.append("phone").append(",");
			sb2.append("'" + user.getPhone() + "'").append(",");
		}
		if (user.getAge() != null) {
			sb1.append("age").append(",");
			sb2.append("'" + user.getAge() + "'").append(",");
		}
		
		String result1 = sb1.toString().substring(0, sb1.toString().length()-1);
		String result2 = sb2.toString().substring(0, sb2.toString().length()-1);
		
		sql="select * from ouser where goodname = '"+user.getUsername()+"'"+"order by id desc";
		
		System.out.println(sql);
		ResultSet resultSet=new DBOpreate().executeQuery(sql);
		
		try {
			if(resultSet.next()){
				try {
					response.getWriter().print("failed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
				
			}else{
				sql="insert into ouser("+result1+") values("+result2+")";
				boolean flag =  new DBOpreate().execute(sql);
				if(flag == true){
					try {
						response.getWriter().print("success");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String user_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from ouser order by id desc";
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
	
	public String user_delete(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);
		System.out.println(msg);
		if(user.getId()==0 || user.getId()==-1){
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
			String sql = "delete  ouser where id ="+user.getId();
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
	
	public String user_update(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);
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
		String sb14= new String();
		String sb15 = new String();
		String sb16= new String();
		
		if (user.getUsername() != null) {
			sb1="username=";
			sb2="'" + user.getUsername() + "',";
		}
		if (user.getPassword() != null) {
			sb3="userpwd=";
			sb4="'" + user.getPassword() + "',";
		}
		if (user.getPhone() != null) {
			sb5="phone=";
			sb6="'" + user.getPhone() + "',";
		}
		if (user.getSex() != null) {
			sb7="sex=";
			sb8="'" + user.getSex() + "',";
		}
		if (user.getBrithday() != null) {
			sb9="brithday=";
			sb10="'" + user.getBrithday() + "',";
		}
		if (user.getEmail() != null) {
			sb11="email=";
			sb12="'" + user.getEmail() + "',";
		}
		if (user.getImgUrl() != null) {
			sb13="imgUrl=";
			sb14="'" + user.getImgUrl() + "',";
		}
		if(user.getAge()!=null){
			sb15="age=";
			sb16="'" + user.getAge() + "',";
		}
		
		sql = "select * from ouser where username = '"+user.getUsername()+"'";
	
		ResultSet flag = new DBOpreate().executeQuery(sql);
		try {
			if(flag.next()){
				//存在当前用户名
				return ERROR;
			}else{
				String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+""+sb9+""+sb10+""+sb11+""+sb12+""+sb13+""+sb14+""+sb15+""+sb16;
				String result = sresult.substring(0, sresult.length()-1);
				sql = "update ouser set "+result+" where id = "+user.getId();
				
				boolean flag2 =  new DBOpreate().execute(sql);
				
				if(flag2 == true){
					try {
						response.getWriter().print("success");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
