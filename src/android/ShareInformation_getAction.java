package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import utils.DBOpreate;

public class ShareInformation_getAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	HttpServletResponse response;
	HttpServletRequest request;
	private String messageId;
	private Integer resultMark;
	private Integer ben;
	private Integer pm2_5;
	private String suggest;
	private Double lng;
	private Double lat;
	private String province;
	private String district;
	private String city;
	private String street;
	private String StreetNum;
	private String userId;
	private String sql;
	
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public Integer getResultMark() {
		return resultMark;
	}
	public void setResultMark(Integer resultMark) {
		this.resultMark = resultMark;
	}
	public Integer getBen() {
		return ben;
	}
	public void setBen(Integer ben) {
		this.ben = ben;
	}
	public Integer getPm2_5() {
		return pm2_5;
	}
	public void setPm2_5(Integer pm2_5) {
		this.pm2_5 = pm2_5;
	}
	public String getSuggest() {
		return suggest;
	}
	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}
	public Double getLng() {
		return lng;
	}
	public void setLng(Double lng) {
		this.lng = lng;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStreetNum() {
		return StreetNum;
	}
	public void setStreetNum(String streetNum) {
		StreetNum = streetNum;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	
	public String execute() throws IOException{
		userId = request.getParameter("");
		sql="";
		ResultSet result = DBOpreate.executeQuery(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(result != null){			
			try {
				JSONObject array = new JSONObject();
				array.put("resultMark", result.getString(""));
				array.put("Ing", result.getString(""));
				array.put("lat", result.getString(""));
				array.put("ben", result.getString(""));
				array.put("pm2_5", result.getString(""));
				array.put("suggest", result.getString(""));
				array.put("province", result.getString(""));
				array.put("district", result.getString(""));
				array.put("city", result.getString(""));
				array.put("street", result.getString(""));
				array.put("StreetNum", result.getString(""));
				
				out.print(array);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}
}
