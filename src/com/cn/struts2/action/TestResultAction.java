package com.cn.struts2.action;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeyResultRecord;
import utils.DBOpreate;

public class TestResultAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	public String TestResult_update(){
		String id = request.getParameter("");
		String userId = request.getParameter("");
		String resultMark = request.getParameter("");
		String ben = request.getParameter("");
		String pm2_5 = request.getParameter("");
		String suggest = request.getParameter("");
		String lng = request.getParameter("");
		String lat = request.getParameter("");
		String province = request.getParameter("");
		String district = request.getParameter("");
		String city = request.getParameter("");
		String street = request.getParameter("");
		String streetNum = request.getParameter("");
		
		String sb1 = new String();
		String sb2 = new String();
		String sb3 = new String();
		String sb4 = new String();
		String sb5 = new String();
		String sb6 = new String();
		String sb7 = new String();
		String sb8 = new String();
		String sb9 = new String();
		String sb10 = new String();
		String sb11 = new String();
		String sb12 = new String();
		String sb13 = new String();
		String sb14= new String();
		String sb15 = new String();
		String sb16= new String();
		String sb17 = new String();
		String sb18 = new String();
		String sb19 = new String();
		String sb20= new String();
		String sb21= new String();
		String sb22 = new String();
		
		if (resultMark != null) {
			sb1="resultMark=";
			sb2="'" + resultMark + "',";
		}
		if (ben != null) {
			sb3="ben=";
			sb4="'" + ben + "',";
		}
		if (pm2_5 != null) {
			sb5="pm2_5=";
			sb6="'" + pm2_5 + "',";
		}
		if (suggest != null) {
			sb7="suggest=";
			sb8="'" + suggest + "',";
		}
		if (lng != null) {
			sb9="lng=";
			sb10="'" + lng + "',";
		}
		if (lat != null) {
			sb11="lat=";
			sb12="'" + lat + "',";
		}
		if (province != null) {
			sb13="province=";
			sb14="'" + province + "',";
		}
		if(district!=null){
			sb15="district=";
			sb16="'" + district + "',";
		}
		if(city!=null){
			sb17="city=";
			sb18="'" + city + "',";
		}
		if(street!=null){
			sb19="street=";
			sb20="'" + street + "',";
		}
		if(streetNum!=null){
			sb21="streetNum=";
			sb22="'" + streetNum + "',";
		}
		String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+""+sb9+""+sb10+""+sb11+""+sb12+""+sb13+""+sb14+""+sb15+""+sb16+""+sb17+""+sb18+""+sb19+""+sb20+""+sb21+""+sb22;
		String result = sresult.substring(0, sresult.length()-1);
		sql = "update onekeyResultRecord set "+result+" where id = "+id;
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		try {
			if(flag.next()){
				return SUCCESS;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String TestResult_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from onekeyResultRecord";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		ArrayList<OnekeyResultRecord> recordData = new ArrayList<>();
		try {
			while(result.next()){
				OnekeyResultRecord record = new OnekeyResultRecord();
				record.setId(result.getInt("id"));
				record.setUserId(result.getString("userid"));
				record.setResultMark(result.getInt("resultMark"));
				record.setBen(result.getInt("ben"));
				record.setPm2_5(result.getInt("pm2_5"));
				record.setSuggest(result.getString("suggest"));
				record.setLat(result.getDouble("lat"));
				record.setLng(result.getDouble("lng"));
				record.setProvince(result.getString("province"));
				record.setDistrict(result.getString("district"));
				record.setCity(result.getString("city"));
				record.setStreet(result.getString("street"));
				record.setStreetNum(result.getString("streetNum"));
				record.setDriverId(result.getString("driverId"));
				recordData.add(record);
				}
			String data = gson.toJson(recordData);
			try {
				response.setContentType("text/html;charset=UTF-8");
				response.getWriter().println(data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
}
