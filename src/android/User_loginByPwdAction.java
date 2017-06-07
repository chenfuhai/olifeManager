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
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		Query query = gson.fromJson(msg, Query.class);
		String[] a = query.getWhereEqualTo();
		sql = "select * from '" + query.getTableName() + "' where '" + a[0] + "' = '" + a[1] + "' and '" + a[2] + "' = '" + a[3] + "'";
		ResultSet result = DBOpreate.executeQuery(sql);	
		if (result != null) {
			User user = new User();
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
		return null;
	}
}
