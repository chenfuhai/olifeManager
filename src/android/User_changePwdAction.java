package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;
import utils.NetUtils;
import utils.UserPwdChange;

public class User_changePwdAction extends ActionSupport {
	// 先查询数据库中旧密码会不会对 如果正确 更改新密码
	private String sql;

	public String execute() {

		try {
			String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
			Gson gson = new GsonBuilder().serializeNulls().create();
			UserPwdChange user = gson.fromJson(msg, UserPwdChange.class);
			String sqlold = "select Top 1 * from ouser where id = " + user.getId() + "and userpwd='" + user.getOldPwd()
					+ "'";
			ResultSet resultSet = DBOpreate.executeQuery(sqlold);
			boolean flag = false;
			if (resultSet.next()) {
				// 替换旧密码
				sql = "update ouser set userpwd = '" + user.getNewPwd() + "' where id = " + user.getId();
				flag = DBOpreate.execute(sql);
			}

			if (flag == true) {
				ServletActionContext.getResponse().getWriter().println("success");
			} else {
				ServletActionContext.getResponse().getWriter().println("failed");
			}
		} catch (JsonSyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
