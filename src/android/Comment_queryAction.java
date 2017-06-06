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

import entity.Feedback;
import entity.OnekeySharedDisc;
import net.sf.json.JSONObject;
import utils.DBOpreate;
import utils.NetUtils;
import utils.Query;

/**
 * 
 */
public class Comment_queryAction extends ActionSupport {
	private String sql;

	public String execute() throws IOException {
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		Query query = gson.fromJson(msg, Query.class);
		String[] a = query.getWhereEqualTo();
		sql = "select * from '" + query.getTableName() + "' where '" + a[0] + "' = '" + a[1] + "'";
		ResultSet result = DBOpreate.executeQuery(sql);
		if (result != null) {
			OnekeySharedDisc disc = new OnekeySharedDisc();
			try {
				disc.setId(Integer.parseInt(result.getString("id")));
				disc.setSharedMessageId(result.getString("sharedMessageId"));
				disc.setUserId(result.getString("userid"));
				disc.setUserImgUrl(result.getString("userimgUrl"));
				disc.setUsername(result.getString("username"));
				if (result.getString("usersex") == "男") {
					disc.setUsersex(true);
				} else {
					disc.setUsersex(false);
				}
				;
				disc.setUserage(result.getString("userage"));
				disc.setMessage(result.getString("discmessage"));

				String data = gson.toJson(disc);
				ServletActionContext.getResponse().getWriter().println(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
