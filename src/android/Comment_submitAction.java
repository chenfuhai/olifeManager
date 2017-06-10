package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeySharedDisc;
import utils.DBOpreate;
import utils.NetUtils;
import utils.Query;

/**
 * 
 */
public class Comment_submitAction extends ActionSupport {
	private String sql;

	public String execute() throws IOException {
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedDisc disc = gson.fromJson(msg, OnekeySharedDisc.class);
		
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
		String result1 = sb1.toString().substring(0, sb1.toString().length()-1);
		String result2 = sb2.toString().substring(0, sb2.toString().length()-1);
		sql = "insert into onekeySharedDisc(" + result1 + ") values(" + result2 + ")";

		boolean flag = new DBOpreate().execute(sql);

		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;

	}

}
