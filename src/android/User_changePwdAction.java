package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import utils.DBOpreate;
import utils.NetUtils;
import utils.UserPwdChange;

public class User_changePwdAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		UserPwdChange user = gson.fromJson(msg, UserPwdChange.class);
		// 声明两个StringBuffer，sb1存列名，sb2存数据
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		StringBuffer sb3 = new StringBuffer();
		StringBuffer sb4 = new StringBuffer();
		// 对列中的数据进行判断
		if (user.getId() != 0) {
			sb1.append("userid");
			sb2.append("'" + user.getId() + "'");
		}
		if (user.getNewPwd() != null) {
			sb3.append("userpwd");
			sb4.append("'" + user.getNewPwd() + "'");
		}
		
		sql = "update ouser set '"+sb3+"'='"+sb4+"' where '"+sb1+"'='"+sb2+"'";

		boolean flag = DBOpreate.execute(sql);

		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
