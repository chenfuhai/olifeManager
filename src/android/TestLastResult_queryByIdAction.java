package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeyResultRecord;
import utils.DBOpreate;
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

public class TestLastResult_queryByIdAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sql;

	public String execute() {

		try {
			String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
			Gson gson = new GsonBuilder().serializeNulls().create();
			System.out.println(msg);
			Query query = gson.fromJson(msg, Query.class);
			String[] a = query.getWhereEqualTo();

			System.out.println(query);

			try {

				sql = JudgeSQL.jSQL("onekeyResultRecord", a[0], a[1], query.getLimit(), query.getOrder(),
						query.getSkip());

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// sql="select * from onekeyResultRecord where '"+a[0]+"' =
			// '"+a[1]+"'";
			System.out.println(sql);
			ArrayList<OnekeyResultRecord> lists = new ArrayList<>();

			ResultSet result = null;

			result = new DBOpreate().executeQuery(sql);

			while (result.next()) {
				OnekeyResultRecord record = new OnekeyResultRecord();

				System.out.println(result.getString("lng"));
				record.setId(result.getInt("id"));
				record.setUserId(result.getInt("userid") + "");
				if (result.getString("resultMark") != null) {
					record.setResultMark(Integer.parseInt(result.getString("resultMark")));
				}
				if (result.getString("ben")!=null) {
					record.setBen(Integer.parseInt(result.getString("ben")));
				}
				if (result.getString("pm2_5")!=null) {
					record.setPm2_5(Integer.parseInt(result.getString("pm2_5")));
				}
				if (result.getString("suggest")!=null) {
					record.setSuggest(result.getString("suggest"));
				}
				if (result.getString("lng")!=null) {
					record.setLng(Double.parseDouble(result.getString("lng")));
				}
				if (result.getString("lat")!=null) {
					record.setLat(Double.parseDouble(result.getString("lat")));
				}
				record.setProvince(result.getString("province"));
				record.setDistrict(result.getString("district"));
				record.setCity(result.getString("city"));
				record.setStreet(result.getString("street"));
				record.setStreetNum(result.getString("streetNum"));
				record.setDriverId(result.getString("driverId"));

				lists.add(record);
			}
			System.out.println(lists.size());
			System.out.println(lists.get(0).toString());
			String data = gson.toJson(lists);
			System.out.println(data);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8;");
			response.getWriter().println(data);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}
}
