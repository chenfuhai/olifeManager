package android;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeyResultRecord;
import utils.DBOpreate;
import utils.NetUtils;
import utils.Query;

public class TestLastResult_queryByIdAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException {		
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		Query query = gson.fromJson(msg,Query.class);
		String[] a = query.getWhereEqualTo();
		sql="select * from '"+query.getTableName()+"' where '"+a[0]+"' = '"+a[1]+"'";
		ResultSet result = DBOpreate.executeQuery(sql);
		if(result!=null){
			OnekeyResultRecord record = new OnekeyResultRecord();
			try {
				record.setId(Integer.parseInt(result.getString("id")));
				record.setUserId(result.getString("userid"));
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
				String data = gson.toJson(record);
				ServletActionContext.getResponse().getWriter().println(data);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		return null;
	}
}
