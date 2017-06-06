package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import utils.DBOpreate;
import utils.NetUtils;

public class User_updateAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);
		// 声明两个StringBuffer，sb1存列名，sb2存数据
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = new StringBuffer();
		StringBuffer sb4 = new StringBuffer();
		StringBuffer sb5 = new StringBuffer();
		StringBuffer sb6 = new StringBuffer();
		StringBuffer sb7 = new StringBuffer();
		StringBuffer sb8 = new StringBuffer();
		StringBuffer sb9 = new StringBuffer();
		StringBuffer sb10 = new StringBuffer();
		StringBuffer sb11 = new StringBuffer();
		StringBuffer sb12 = new StringBuffer();
		// 对列中的数据进行判断
		if (user.getId() != 0) {
			sb1.append("userid");
			sb2.append("'" + user.getId() + "'");
		}
		if (user.getUsername() != null) {
			sb3.append("username");
			sb4.append("'" + user.getUsername() + "'");
		}
		if (user.getPhone() != null) {
			sb5.append("phone");
			sb6.append("'" + user.getPhone() + "'");
		}
		if (user.getSex() != null) {
			sb7.append("sex");
			sb8.append("'" + user.getSex() + "'");
		}
		if (user.getBrithday() != null) {
			sb9.append("brithday");
			sb10.append("'" + user.getBrithday() + "'");
		}
		if (user.getEmail() != null) {
			sb11.append("email");
			sb12.append("'" + user.getEmail() + "'");
		}
		sql = "update ouser set '"+sb3+"'='"+sb4+"'and '"+sb5+"'='"+sb6+"'and '"+sb7+"'='"+sb8+"'and '"+sb9+"'='"+sb10+"'and '"+sb11+"'='"+sb12+"' where '"+sb1+"'='"+sb2+"'";

		boolean flag = DBOpreate.execute(sql);

		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
