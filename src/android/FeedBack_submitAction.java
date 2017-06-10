package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.opensymphony.xwork2.ActionSupport;

import entity.Feedback;
import utils.DBOpreate;
import utils.NetUtils;

public class FeedBack_submitAction extends ActionSupport {
	private String sql;

	public String execute()  {
		
		try {
			String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
			Gson gson = new GsonBuilder().serializeNulls().create();
			Feedback feedback = gson.fromJson(msg, Feedback.class);
			System.out.println(msg);
			StringBuffer sb1 = new StringBuffer();
			StringBuffer sb2 = new StringBuffer();
			
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
				sb1.append("phone").append(",");
				sb2.append("'" + feedback.getPhone() + "'").append(",");
			}
			String result1 = sb1.toString().substring(0, sb1.toString().length()-1);
			String result2 = sb2.toString().substring(0, sb2.toString().length()-1);
			
			sql = "insert into feedback(" + result1 + ") values(" + result2 + ")";
			System.out.println(sql);
			boolean flag = false;
			try {
				flag = new DBOpreate().execute(sql);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(flag);
			if (flag == true) {
				ServletActionContext.getResponse().getWriter().println("success");
			} else {
				ServletActionContext.getResponse().getWriter().println("failed");
			}
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
