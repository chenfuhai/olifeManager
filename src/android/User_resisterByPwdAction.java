package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import utils.DBOpreate;
import utils.NetUtils;

/**
 * �û�ע�� ������
 */
public class User_resisterByPwdAction extends ActionSupport {
	private String sql;

	public String execute() throws IOException {
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);

		sql = "select * from ouser where username = '" + user.getUsername() + "' or email='" + user.getUsername()
				+ "'or phone='" + user.getUsername() + "'";

		ResultSet result = DBOpreate.executeQuery(sql);

		try {
			if (result.next()) {
				// 有结果 说明存在用户 返回false
				ServletActionContext.getResponse().getWriter().println("failed");
				return null;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 声明两个StringBuffer，sb1存列名，sb2存数据
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		// 对列中的数据进行判断
		if (user.getUsername() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + user.getUsername() + "'").append(",");
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
			sb1.append("userage").append("'");
			sb2.append("'" + user.getAge() + "'").append(",");
		}
		String resultSb1 = sb1.toString().substring(0, sb1.toString().length() - 1);
		String resultSb2 = sb2.toString().substring(0, sb2.toString().length() - 1);
		sql = "insert into ouser(" + resultSb1 + ") values(" + resultSb2 + ")";

		boolean flag = false;
		try {
			flag = DBOpreate.execute(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(flag);

		if (flag == true) {

			sql = "select Top 1 * from ouser where username = '" + user.getUsername() + "' or email='"
					+ user.getUsername() + "'or phone='" + user.getUsername() + "'";

			ResultSet result1 = DBOpreate.executeQuery(sql);
			try {
				result1.next();
				if (user.getPassword().equals(result1.getString("userpwd"))) {

					user.setAge(result1.getString("age"));
					user.setBrithday(result1.getString("brithday"));
					user.setEmail(result1.getString("email"));
					user.setId(Integer.parseInt(result1.getString("id")));
					user.setImgUrl(result1.getString("imgUrl"));
					user.setPassword(result1.getString("userpwd"));
					user.setPhone(result1.getString("phone"));
					user.setSex(result1.getString("sex"));
					user.setUsername(result1.getString("username"));
					String data = gson.toJson(user);
					ServletActionContext.getResponse().getWriter().println(data);
					System.out.println(data);
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
