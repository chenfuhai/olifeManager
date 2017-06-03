package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class User_loginByPwdAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	HttpServletRequest request;
	HttpServletResponse response;
	
	private String userId;
	private String userPwd;
	private String sql;
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	public String execute() throws IOException{
		userId = request.getParameter("");
		userPwd = request.getParameter("");
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		sql="";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			out.print("µÇÂ¼³É¹¦");
		}
		return null;
	}
}
