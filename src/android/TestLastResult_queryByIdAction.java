package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
		
		Query query = gson.fromJson(msg, Query.class);
		String[] a = query.getWhereEqualTo();
		
		
		try {
			sql = JudgeSQL.jSQL("onekeyResultRecord", a[0], a[1], query.getLimit(), query.getOrder(), query.getSkip());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// sql="select * from onekeyResultRecord where '"+a[0]+"' = '"+a[1]+"'";
		System.out.println(sql);
		ArrayList<OnekeyResultRecord> lists = new ArrayList<>();
		
			ResultSet result = DBOpreate.executeQuery(sql);
			while(result.next()){
				OnekeyResultRecord record = new OnekeyResultRecord();

				record.setId(Integer.parseInt(result.getString("id")));
				record.setUserId(result.getInt("userid")+"");
				record.setResultMark(Integer.parseInt(result.getString("resultMark")));
				record.setBen(Integer.parseInt(result.getString("ben")));
				record.setPm2_5(Integer.parseInt(result.getString("pm2_5")));
				record.setSuggest(result.getString("suggest"));
				record.setLng(Double.parseDouble(result.getString("lng")));
				record.setLat(Double.parseDouble(result.getString("lat")));
				record.setProvince(result.getString("province"));
				record.setDistrict(result.getString("district"));
				record.setCity(result.getString("city"));
				record.setStreet(result.getString("street"));
				record.setStreetNum(result.getString("streetNum"));
				record.setDriverId(result.getString("driverId"));
				
				lists.add(record);
			}
				
			String data = gson.toJson(lists);
			ServletActionContext.getResponse().getWriter().println(data);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

		return null;
	}
}
