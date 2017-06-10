package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Feedback;
import entity.OnekeyResultRecord;
import net.sf.json.JSONObject;
import utils.DBOpreate;
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

/**
 * 
 */
public class TestResult_queryByIdAction extends ActionSupport {
	private String sql;

	public String execute(){
		try {
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		Query query = gson.fromJson(msg, Query.class);
		String[] a = query.getWhereEqualTo();
		sql = JudgeSQL.jSQL("onekeyResultRecord", a[0], a[1], query.getLimit(), query.getOrder(), query.getSkip());
		// sql="select * from onekeyResultRecord where '"+a[0]+"' = '"+a[1]+"'";
		ArrayList<OnekeyResultRecord> list = new ArrayList<>();
		
			ResultSet result = new DBOpreate().executeQuery(sql);
			while (result.next()) {
				OnekeyResultRecord record = new OnekeyResultRecord();

				record.setId(result.getInt("id"));
				record.setUserId(result.getInt("userid")+"");
				if (result.getString("resultMark")!=null) {
					record.setResultMark(Integer.parseInt(result.getString("resultMark")));					
				}
				if (result.getString("lat")!=null) {
					record.setLat(Double.parseDouble(result.getString("lat")));
				}
				if (result.getString("lng")!=null) {
					record.setLng(Double.parseDouble(result.getString("lng")));
				}
				if (result.getString("pm2_5")!=null) {
					record.setPm2_5(Integer.parseInt(result.getString("pm2_5")));
				}
				if (result.getString("ben")!=null) {
					record.setBen(Integer.parseInt(result.getString("ben")));
				}
				record.setSuggest(result.getString("suggest"));
				record.setProvince(result.getString("province"));
				record.setDistrict(result.getString("district"));
				record.setCity(result.getString("city"));
				record.setStreet(result.getString("street"));
				record.setStreetNum(result.getString("streetNum"));
				record.setDriverId(result.getString("driverId"));
				list.add(record);
			}

			String data = gson.toJson(list);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("text/html;charset=UTF-8;");
			response.getWriter().println(data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}

		return null;
	}

}
