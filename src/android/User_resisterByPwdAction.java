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
import entity.User;
import utils.DBOpreate;
import utils.NetUtils;
/**
 * �û�ע�� ������
 */
public class User_resisterByPwdAction extends ActionSupport {
	private String sql;

	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);
		System.out.println(msg);
		System.out.println(user.toString());
		// 声明两个StringBuffer，sb1存列名，sb2存数据
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		// 对列中的数据进行判断
		if (user.getId() != 0) {
			sb1.append("userid").append(",");
			sb2.append("'" + user.getId() + "'").append(",");
		}
		if (user.getPassword() != null) {
			sb1.append("userpwd");
			sb2.append("'" + user.getPassword() + "'");
		}
		sql = "insert into ouser(" + sb1.toString() + ") values(" + sb2.toString() + ")";

		System.out.println(sql);
		boolean flag = DBOpreate.execute(sql);

		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
