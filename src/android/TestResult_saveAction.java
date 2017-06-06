package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeyResultRecord;
import entity.OnekeySharedDisc;
import utils.DBOpreate;
import utils.NetUtils;
/**
 * ������Խ�� ������
 */
public class TestResult_saveAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeyResultRecord record = gson.fromJson(msg, OnekeyResultRecord.class);
		// 声明两个StringBuffer，sb1存列名，sb2存数据
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		// 对列中的数据进行判断
		if (record.getUserId() != null) {
			sb1.append("userid").append(",");
			sb2.append("'" + record.getUserId() + "'").append(",");
		}
		if (record.getResultMark() != null) {
			sb1.append("resultMark").append(",");
			sb2.append("'" + record.getResultMark() + "'").append(",");
		}
		if (record.getBen() != null) {
			sb1.append("ben").append(",");
			sb2.append("'" + record.getBen() + "'").append(",");
		}
		if (record.getPm2_5() != null) {
			sb1.append("pm2_5").append(",");
			sb2.append("'" + record.getPm2_5() + "'").append(",");
		}
		if (record.getSuggest() != null) {
			sb1.append("suggest").append(",");
			sb2.append("'" + record.getSuggest() + "'").append(",");
		}
		if (record.getLng() != null) {
			sb1.append("lng").append(",");
			sb2.append("'" + record.getLng() + "'").append(",");
		}
		if (record.getLat() != null) {
			sb1.append("lat");
			sb2.append("'" + record.getLat() + "'");
		}
		if (record.getProvince() != null) {
			sb1.append("province").append(",");
			sb2.append("'" + record.getProvince() + "'").append(",");
		}
		if (record.getDistrict() != null) {
			sb1.append("district").append(",");
			sb2.append("'" + record.getDistrict() + "'").append(",");
		}
		if (record.getCity() != null) {
			sb1.append("city").append(",");
			sb2.append("'" + record.getCity() + "'").append(",");
		}
		if (record.getStreet() != null) {
			sb1.append("street").append(",");
			sb2.append("'" + record.getStreet() + "'").append(",");
		}
		if (record.getStreetNum() != null) {
			sb1.append("streetNum").append(",");
			sb2.append("'" + record.getStreetNum() + "'").append(",");
		}
		if (record.getDriverId() != null) {
			sb1.append("driverId");
			sb2.append("'" + record.getDriverId() + "'");
		}

		sql = "insert into onekeySharedDisc(" + sb1.toString() + ") values(" + sb2.toString() + ")";	
		boolean flag = DBOpreate.execute(sql);
		
		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
