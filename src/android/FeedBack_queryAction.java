package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Feedback;
import utils.DBOpreate;
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

public class FeedBack_queryAction extends ActionSupport {
	private String sql;

	public String execute() {
		ArrayList<Feedback> feedbacks = new ArrayList<>();

		Gson gson = new GsonBuilder().create();
		try {
			String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());

			Query query = gson.fromJson(msg, Query.class);
			sql = JudgeSQL.jSQL("feedback", null, null, query.getLimit(), query.getOrder(), query.getSkip());

			ResultSet result = DBOpreate.executeQuery(sql);
			while (result.next()) {
				Feedback feedback = new Feedback();

				feedback.setEmail(result.getString("email"));
				feedback.setMessage(result.getString("feedbackMsg"));
				feedback.setPhone(result.getString("phone"));
				feedback.setQQ(result.getString("qq"));
				feedback.setUserAge(result.getString("userage"));
				
				feedback.setUserName(result.getString("username"));
				feedback.setUserSex(result.getString("usersex"));
				feedback.setId(Integer.parseInt(result.getString("id")));

				feedbacks.add(feedback);

			}

			String data = gson.toJson(feedbacks);
			ServletActionContext.getResponse().getWriter().println(data);
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
