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
			sb1.append("username").append(",");
			sb2.append("'" + user.getId() + "'").append(",");
		}
		if (user.getPassword() != null) {
			sb1.append("userpwd").append(",");
			sb2.append("'" + user.getPassword() + "'").append(",");
		}
		if (user.getSex() != null) {
			sb1.append("sex").append(",");
			sb2.append("'" + user.getSex() + "'").append(",");
		}
		if (user.getImgUrl() != null) {
			sb1.append("imgUrl").append(",");
			sb2.append("'" + user.getImgUrl() + "'").append(",");
		}
		if (user.getBrithday() != null) {
			sb1.append("brithday").append(",");
			sb2.append("'" + user.getBrithday() + "'").append(",");
		}
		if (user.getEmail() != null) {
			sb1.append("email").append(",");
			sb2.append("'" + user.getEmail() + "'").append(",");
		}
		if (user.getPhone() != null) {
			sb1.append("phone").append(",");
			sb2.append("'" + user.getPhone() + "'").append(",");
		}
		if (user.getAge() != null) {
			sb1.append("userage");
			sb2.append("'" + user.getAge() + "'");
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
