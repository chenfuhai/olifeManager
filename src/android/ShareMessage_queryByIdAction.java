package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeySharedMessage;
import utils.DBOpreate;
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

public class ShareMessage_queryByIdAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();	
		Query query = gson.fromJson(msg, Query.class);
		String[] a = query.getWhereEqualTo();
		sql = JudgeSQL.judgeSQL("onekeySharedMessage",a[0],a[1], query.getLimit(), query.getOrder(), query.getSkip());
		//sql = "select * from onekeySharedMessage where '"+a[0]+"'='"+a[1]+"'";
		ResultSet result = DBOpreate.executeQuery(sql);
		if (result != null) {
			OnekeySharedMessage message = new OnekeySharedMessage();
			try {
				message.setMessageid(Integer.parseInt(result.getString("messageid")));
				message.setUserId(result.getString("userid"));
				message.setResultMark(Integer.parseInt(result.getString("resultMark")));	
				message.setBen(Integer.parseInt(result.getString("ben")));
				message.setPm2_5(Integer.parseInt(result.getString("pm2_5")));
				message.setSuggest(result.getString("suggest"));
				message.setLng(Double.parseDouble(result.getString("ing")));
				message.setLat(Double.parseDouble(result.getString("lat")));
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

				String data = gson.toJson(message);
				ServletActionContext.getResponse().getWriter().println(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
