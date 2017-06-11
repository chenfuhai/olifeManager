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

import utils.DBOpreate;

public class FeedbackOperationAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	private ArrayList<Feedback> feedbackData;
    
	public String feedback_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from feedback order by id desc";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		feedbackData = new ArrayList<>();
		try {
			while(result.next()){
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
	

}
