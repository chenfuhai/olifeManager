package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Feedback;
import utils.DBOpreate;
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

public class FeedBack_queryAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		Query query = gson.fromJson(msg,Query.class);
		sql = JudgeSQL.judgeSQL("feedback",null,null,query.getLimit(), query.getOrder(), query.getSkip());
		ResultSet result = DBOpreate.executeQuery(sql);
		if(result!=null){
			Feedback feedback = new Feedback();
			try {
				feedback.setEmail(result.getString("email"));
				feedback.setMessage(result.getString("feedbackMsg"));
				feedback.setPhone(result.getString("phone"));
				feedback.setQQ(result.getString("qq"));
				feedback.setUserAge(result.getString("userage"));
				feedback.setUserId(result.getString("userid"));
				feedback.setUserName(result.getString("username"));
				feedback.setUserSex(result.getString("usersex"));
				feedback.setId(Integer.parseInt(result.getString("id")));
				String data = gson.toJson(feedback);
				ServletActionContext.getResponse().getWriter().println(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
