package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeyResultRecord;
import entity.OnekeySharedMessage;
import utils.DBOpreate;
import utils.NetUtils;

public class ShareMessage_saveAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedMessage message = gson.fromJson(msg, OnekeySharedMessage.class);
		// 声明两个StringBuffer，sb1存列名，sb2存数据
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		// 对列中的数据进行判断
		if (message.getUserId() != null) {
			sb1.append("userid").append(",");
			sb2.append("'" + message.getUserId() + "'").append(",");
		}
		if (message.getResultMark() != null) {
			sb1.append("resultMark").append(",");
			sb2.append("'" + message.getResultMark() + "'").append(",");
		}
		if (message.getBen() != null) {
			sb1.append("ben").append(",");
			sb2.append("'" + message.getBen() + "'").append(",");
		}
		if (message.getPm2_5() != null) {
			sb1.append("pm2_5").append(",");
			sb2.append("'" + message.getPm2_5() + "'").append(",");
		}
		if (message.getSuggest() != null) {
			sb1.append("suggest").append(",");
			sb2.append("'" + message.getSuggest() + "'").append(",");
		}
		if (message.getLng() != null) {
			sb1.append("lng").append(",");
			sb2.append("'" + message.getLng() + "'").append(",");
		}
		if (message.getLat() != null) {
			sb1.append("lat");
			sb2.append("'" + message.getLat() + "'");
		}
		if (message.getProvince() != null) {
			sb1.append("province").append(",");
			sb2.append("'" + message.getProvince() + "'").append(",");
		}
		if (message.getDistrict() != null) {
			sb1.append("district").append(",");
			sb2.append("'" + message.getDistrict() + "'").append(",");
		}
		if (message.getCity() != null) {
			sb1.append("city").append(",");
			sb2.append("'" + message.getCity() + "'").append(",");
		}
		if (message.getStreet() != null) {
			sb1.append("street").append(",");
			sb2.append("'" + message.getStreet() + "'").append(",");
		}
		if (message.getStreetNum() != null) {
			sb1.append("streetNum").append(",");
			sb2.append("'" + message.getStreetNum() + "'").append(",");
		}
		if (message.getUsername() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + message.getUsername() + "'").append(",");
		}
		if (message.getUserImgUrl() != null) {
			sb1.append("userImgUrl").append(",");
			sb2.append("'" + message.getUserImgUrl() + "'").append(",");
		}
		if (message.getUserphone() != null) {
			sb1.append("userphont").append(",");
			sb2.append("'" + message.getUserphone() + "'").append(",");
		}
		if (message.getUseremail() != null) {
			sb1.append("useremail").append(",");
			sb2.append("'" + message.getUseremail() + "'").append(",");
		}
		if (message.getUsersex() != null) {
			sb1.append("usersex").append(",");
			sb2.append("'" + message.getUsersex() + "'").append(",");
		}
		if (message.getUserage() != null) {
			sb1.append("userage").append(",");
			sb2.append("'" + message.getUserage() + "'").append(",");
		}
		if (message.getDriverId() != null) {
			sb1.append("driverId").append(",");
			sb2.append("'" + message.getDriverId() + "'").append(",");
		}
		String result1 = sb1.toString().substring(0, sb1.toString().length()-1);
		String result2 = sb2.toString().substring(0, sb2.toString().length()-1);
		sql = "insert into onekeySharedMessage(" + result1 + ") values(" + result2 + ")";	
		boolean flag = DBOpreate.execute(sql);
		
		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
