package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeySharedMessage;
import utils.DBOpreate;
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

public class ShareMessage_queryByIdAction extends ActionSupport {
	private String sql;

	public String execute() throws IOException {
		try {
			String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
			Gson gson = new GsonBuilder().create();
			Query query = gson.fromJson(msg, Query.class);
			String[] a = query.getWhereEqualTo();
			sql = JudgeSQL.jSQL("onekeySharedMessage", a[0], a[1], query.getLimit(), query.getOrder(),
					query.getSkip());
			// sql = "select * from onekeySharedMessage where
			// '"+a[0]+"'='"+a[1]+"'";
			ArrayList<OnekeySharedMessage> list = new ArrayList<>();
			ResultSet result = new DBOpreate().executeQuery(sql);
			while (result.next()) {
				OnekeySharedMessage message = new OnekeySharedMessage();

				message.setId(result.getInt("id"));
				message.setUserId(result.getInt("userid")+"");
				if (result.getString("resultMark")!=null) {
					message.setResultMark(Integer.parseInt(result.getString("resultMark")));
				}
				if (result.getString("ben")!=null) {
					message.setBen(Integer.parseInt(result.getString("ben")));
				}
				if (result.getString("pm2_5")!=null) {
					message.setPm2_5(Integer.parseInt(result.getString("pm2_5")));
				}
				if (result.getString("ing")!=null) {
					message.setLng(Double.parseDouble(result.getString("ing")));
				}
				if (result.getString("lat")!=null) {
					message.setLat(Double.parseDouble(result.getString("lat")));
				}
				message.setSuggest(result.getString("suggest"));
				message.setProvince(result.getString("province"));
				message.setDistrict(result.getString("district"));
				message.setCity(result.getString("city"));
				message.setStreet(result.getString("street"));
				message.setStreetNum(result.getString("streetNum"));
				message.setUsername(result.getString("username"));
				message.setUserImgUrl(result.getString("userimgUrl"));
				message.setUserphone(result.getString("userphont"));
				message.setUseremail(result.getString("useremail"));
				message.setUsersex(result.getString("usersex"));
				message.setUserage(result.getString("userage"));
				message.setDriverId(result.getString("driverId"));
				list.add(message);
			}
			

			String data = gson.toJson(list);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8;");
			response.getWriter().println(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
