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
		boolean flag = DBOpreate.execute(sql);
		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		}else{
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
