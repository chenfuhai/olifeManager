package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import utils.Query;
/**
 * �û���¼ ������
 */
public class User_loginByPwdAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException, SQLException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		System.out.println(msg);
		User user = gson.fromJson(msg, User.class);
		System.out.println(user.toString());
		if(user.getUsername()!=null){
			sql="select * from ouser where username = '"+user.getUsername()+"' or email='"+user.getUsername()+"'or phone='"+user.getUsername()+"'";
			System.out.println(sql);
			ResultSet result = DBOpreate.executeQuery(sql);	
			if(user.getPassword().equals(result.getString("userpwd"))){
				try {		
					user.setAge(result.getString("userage"));
					user.setBrithday(result.getString("brithday"));
					user.setEmail(result.getString("email"));
					user.setId(Integer.parseInt(result.getString("id")));user.setImgUrl(result.getString("imgUrl"));
					user.setPassword(result.getString("userpwd"));
					user.setPhone(result.getString("phone"));
					user.setSex(result.getString("sex"));
					user.setUsername(result.getString("username"));
					String data = gson.toJson(user);
					ServletActionContext.getResponse().getWriter().println(data);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}else{
					ServletActionContext.getResponse().getWriter().println("failed");
				}
			
		}
		return null;
	}
}
