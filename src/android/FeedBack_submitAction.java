package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Feedback;
import utils.DBOpreate;
import utils.NetUtils;

public class FeedBack_submitAction extends ActionSupport {
	private String sql;

	public String execute() throws IOException {
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		Feedback feedback = gson.fromJson(msg, Feedback.class);
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		if (feedback.getUserId() != null) {
			sb1.append("userid").append(",");
			sb2.append("'" + feedback.getUserId() + "'").append(",");
		}
		if (feedback.getUserName() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + feedback.getUserName() + "'").append(",");
		}
		if (feedback.getUserAge() != null) {
			sb1.append("userage").append(",");
			sb2.append("'" + feedback.getUserAge() + "'").append(",");
		}
		if (feedback.getUserSex() != null) {
			sb1.append("usersex").append(",");
			sb2.append("'" + feedback.getUserSex() + "'").append(",");
		}
		if (feedback.getMessage() != null) {
			sb1.append("feedbackMsg").append(",");
			sb2.append("'" + feedback.getMessage() + "'").append(",");
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
			sb1.append("phone");
			sb2.append("'" + feedback.getPhone() + "'");
		}
		sql = "insert into feedback(" + sb1.toString() + ") values(" + sb2.toString() + ")";
		boolean flag = DBOpreate.execute(sql);
		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
