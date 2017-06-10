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

import entity.OnekeySharedDisc;
import entity.OnekeySharedMessage;
import utils.DBOpreate;
import utils.NetUtils;
import utils.Query;

public class ShareMessage_queryByLaInAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql;

	public String execute()  {
		String msg=null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(msg);
		Gson gson = new GsonBuilder().create();
		Query query = gson.fromJson(msg, Query.class);
		List a = query.getWhereLessThanOrEqualTo();
		List b = query.getWhereGreaterThanOrEqualTo();
		String[] a1 = (String[]) a.get(0);//lat
		String[] a2 = (String[]) a.get(1);//num
		String[] b1 = (String[]) b.get(0);//lng
		String[] b2 = (String[]) b.get(1);//num
		float[] aa = {Float.parseFloat(a1[1]),Float.parseFloat(a2[1])};
		float[] bb = {Float.parseFloat(b1[1]),Float.parseFloat(b2[1])};
		
		
		sql = "select * from onekeySharedMessage where " + a1[0] + "<=" + aa[0] + " and " + a2[0] + "<=" + aa[1]
				+ " and " + b1[0] + ">=" + bb[0] + " and " + b2[0] + ">=" + bb[1] + "";
		
		ArrayList<OnekeySharedMessage> lists = new ArrayList<>();
		try {
			ResultSet result = new DBOpreate().executeQuery(sql);
			while (result.next()) {

				OnekeySharedMessage message = new OnekeySharedMessage();
				message.setId(result.getInt("id"));
				message.setUserId(result.getInt("userid")+"");
				if (result.getString("resultMark")!=null) {
					message.setResultMark(Integer.parseInt(result.getString("resultMark")));
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
				if (result.getString("ben")!=null) {
					message.setBen(Integer.parseInt(result.getString("ben")));					
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
				
				lists.add(message);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String data = gson.toJson(lists);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8;");
		try {
			response.getWriter().println(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
