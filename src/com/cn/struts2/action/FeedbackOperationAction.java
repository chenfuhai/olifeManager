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

import entity.Feedback;
import entity.Goods;
import utils.DBOpreate;
import utils.NetUtils;

public class FeedbackOperationAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	private ArrayList<Feedback> feedbackData;

	public String feedback_insert() {
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		Feedback feedback = gson.fromJson(msg, Feedback.class);
		System.out.println(msg);

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();

		if (feedback.getMessage() != null) {
			sb1.append("feedbackMsg").append(",");
			sb2.append("'" + feedback.getMessage() + "'").append(",");
		}
		if (feedback.getUserName() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + feedback.getUserName() + "'").append(",");
		}
		if (feedback.getUserSex() != null) {
			sb1.append("usersex").append(",");
			sb2.append("'" + feedback.getUserSex() + "'").append(",");
		}
		if (feedback.getUserAge() != null) {
			sb1.append("userage").append(",");
			sb2.append("'" + feedback.getUserAge() + "'").append(",");
		}
		if (feedback.getEmail() != null) {
			sb1.append("email").append(",");
			sb2.append("'" + feedback.getEmail() + "'").append(",");
		}
		if (feedback.getQQ() != null) {
			sb1.append("qq").append(",");
			sb2.append("'" + feedback.getQQ() + "'").append(",");
		}
		if (feedback.getPhone() != null) {
			sb1.append("phone").append(",");
			sb2.append("'" + feedback.getPhone() + "'").append(",");
		}

		String result1 = sb1.toString().substring(0, sb1.toString().length() - 1);
		String result2 = sb2.toString().substring(0, sb2.toString().length() - 1);

		sql = "insert into feedback(" + result1 + ") values(" + result2 + ")";
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

	public String feedback_show() {
		Gson gson = new GsonBuilder().create();
		sql = "select * from feedback order by id desc";
		ResultSet result = new DBOpreate().executeQuery(sql);
		feedbackData = new ArrayList<>();
		try {
			while (result.next()) {
				Feedback feedback = new Feedback();
				feedback.setId(result.getInt("id"));
				feedback.setEmail(result.getString("email"));
				feedback.setMessage(result.getString("feedbackMsg"));
				feedback.setPhone(result.getString("phone"));
				feedback.setQQ(result.getString("qq"));
				feedback.setUserAge(result.getString("userage"));
				feedback.setUserName(result.getString("username"));
				feedback.setUserSex(result.getString("usersex"));
				feedbackData.add(feedback);
			}
			String data = gson.toJson(feedbackData);
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
	
	public String feedback_delete(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		Feedback feedback = gson.fromJson(msg, Feedback.class);
		System.out.println(msg);
		if(feedback.getId()==0 || feedback.getId()==-1){
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
			String sql = "delete feedback where id ="+feedback.getId();
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
	
	public String feedback_update(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		Feedback feedback = gson.fromJson(msg, Feedback.class);
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
		
		if(feedback.getMessage()!=null){
			sb1="feedbackMsg=";
			sb2="'" + feedback.getMessage() + "',";
		}
		if(feedback.getUserName()!=null){
			sb3="username=";
			sb4="'" + feedback.getUserName() + "',";
		}
		if(feedback.getUserAge()!=null){
			sb5="userage=";
			sb6="'" + feedback.getUserAge() + "',";
		}
		if(feedback.getUserSex()!=null){
			sb7="usersex=";
			sb8="'" + feedback.getUserSex() + "',";
		}
		if(feedback.getEmail()!=null){
			sb9="email=";
			sb10="'" + feedback.getEmail() + "',";
		}
		if(feedback.getQQ()!=null){
			sb11="qq=";
			sb12="'" + feedback.getQQ() + "',";
		}
		if(feedback.getPhone()!=null){
			sb13="phone=";
			sb14="'" + feedback.getPhone() + "',";
		}
		String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+""+""+sb9+""+sb10+""+sb11+""+sb12+""+sb13+""+sb14+"";
		String result = sresult.substring(0, sresult.length()-1);
		sql="select * from feedback where id = '"+feedback.getId()+"'";
		ResultSet result1 = new DBOpreate().executeQuery(sql);
		try {

			if(!result1.next()){
				
				response.getWriter().print("failed");
				return null;
			}else{
				sql="update goods set "+result+" where id = "+feedback.getId();
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
