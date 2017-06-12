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
import com.sun.org.apache.bcel.internal.generic.ALOAD;

import entity.Goods;
import entity.OnekeySharedMessage;
import utils.DBOpreate;
import utils.NetUtils;

public class ShareOperationAction extends ActionSupport {
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;

	public String share_insert() {
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedMessage share = gson.fromJson(msg, OnekeySharedMessage.class);
		System.out.println(msg);

		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();

		if (share.getResultMark() != null) {
			sb1.append("resultMark").append(",");
			sb2.append("'" + share.getResultMark() + "'").append(",");
		}
		if (share.getBen() != null) {
			sb1.append("ben").append(",");
			sb2.append("'" + share.getBen() + "'").append(",");
		}
		if (share.getPm2_5() != null) {
			sb1.append("pm2_5").append(",");
			sb2.append("'" + share.getPm2_5() + "'").append(",");
		}
		if (share.getSuggest() != null) {
			sb1.append("suggest").append(",");
			sb2.append("'" + share.getSuggest() + "'").append(",");
		}
		if (share.getLng() != null) {
			sb1.append("ing").append(",");
			sb2.append("'" + share.getLng() + "'").append(",");
		}
		if (share.getLat() != null) {
			sb1.append("lat").append(",");
			sb2.append("'" + share.getLat() + "'").append(",");
		}
		if (share.getProvince() != null) {
			sb1.append("province").append(",");
			sb2.append("'" + share.getProvince() + "'").append(",");
		}
		if (share.getDistrict() != null) {
			sb1.append("district").append(",");
			sb2.append("'" + share.getDistrict() + "'").append(",");
		}
		if (share.getCity() != null) {
			sb1.append("city").append(",");
			sb2.append("'" + share.getCity() + "'").append(",");
		}
		if (share.getStreet() != null) {
			sb1.append("street").append(",");
			sb2.append("'" + share.getStreet() + "'").append(",");
		}
		if (share.getStreetNum() != null) {
			sb1.append("streetNum").append(",");
			sb2.append("'" + share.getStreetNum() + "'").append(",");
		}
		if (share.getUserId() != null) {
			sb1.append("userid").append(",");
			sb2.append("'" + share.getUserId() + "'").append(",");
		}
		if (share.getUsername() != null) {
			sb1.append("username").append(",");
			sb2.append("'" + share.getUsername() + "'").append(",");
		}
		if (share.getUserImgUrl() != null) {
			sb1.append("userImgUrl").append(",");
			sb2.append("'" + share.getUserImgUrl() + "'").append(",");
		}
		if (share.getUserphone() != null) {
			sb1.append("userphont").append(",");
			sb2.append("'" + share.getUserphone() + "'").append(",");
		}
		if (share.getUseremail() != null) {
			sb1.append("useremail").append(",");
			sb2.append("'" + share.getUseremail() + "'").append(",");
		}
		if (share.getUsersex() != null) {
			sb1.append("usersex").append(",");
			sb2.append("'" + share.getUsersex() + "'").append(",");
		}
		if (share.getUserImgUrl() != null) {
			sb1.append("iconUrl").append(",");
			sb2.append("'" + share.getUserImgUrl() + "'").append(",");
		}
		if (share.getUserage() != null) {
			sb1.append("userage").append(",");
			sb2.append("'" + share.getUserage() + "'").append(",");
		}
		if (share.getDriverId() != null) {
			sb1.append("driverId").append(",");
			sb2.append("'" + share.getDriverId() + "'").append(",");
		}

		String result1 = sb1.toString().substring(0, sb1.toString().length() - 1);
		String result2 = sb2.toString().substring(0, sb2.toString().length() - 1);

		sql = "insert into onekeySharedMessage (" + result1 + ") values(" + result2 + ")";
		boolean flag = new DBOpreate().execute(sql);
		if (flag == true) {
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}

	public String Share_show() {
		Gson gson = new GsonBuilder().create();
		sql = "select * from onekeySharedMessage order by id desc";
		ResultSet result = new DBOpreate().executeQuery(sql);
		ArrayList<OnekeySharedMessage> shareData = new ArrayList<>();
		try {
			while (result.next()) {
				OnekeySharedMessage message = new OnekeySharedMessage();
				message.setId(result.getInt("id"));
				message.setResultMark(result.getInt("resultMark"));
				message.setBen(result.getInt("ben"));
				message.setPm2_5(result.getInt("pm2_5"));
				message.setSuggest(result.getString("suggest"));
				message.setLng(result.getDouble("ing"));
				message.setLat(result.getDouble("lat"));
				message.setProvince(result.getString("province"));
				message.setDistrict(result.getString("district"));
				message.setCity(result.getString("city"));
				message.setStreet(result.getString("street"));
				message.setStreetNum(result.getString("streetNum"));
				message.setUserId(result.getString("userid"));
				message.setUsername(result.getString("username"));
				message.setUserphone(result.getString("userphont"));
				message.setUserImgUrl(result.getString("userImgUrl"));
				message.setUseremail(result.getString("useremail"));
				message.setUsersex(result.getString("usersex"));
				message.setUserage(result.getString("userage"));
				message.setDriverId(result.getString("driverId"));

				shareData.add(message);
			}
			String data = gson.toJson(shareData);
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
	
	public String share_delete(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedMessage share = gson.fromJson(msg, OnekeySharedMessage.class);
		System.out.println(msg);
		if(share.getId()==0 || share.getId()==-1){
			//do not execute the sql
			response.setContentType("text/html;charset=UTF-8");
			try {
				response.getWriter().print("failed");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}{
			//safe
			String sql = "delete onekeySharedMessage where id ="+share.getId();
			boolean flag= new DBOpreate().execute(sql);
			if(flag){
				try {
					response.getWriter().print("success");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				try {
					response.getWriter().print("failed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}

	public String Share_update() {
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		OnekeySharedMessage share = gson.fromJson(msg, OnekeySharedMessage.class);
		System.out.println(msg);

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
		String sb14 = new String();
		String sb15 = new String();
		String sb16 = new String();
		String sb17 = new String();
		String sb18 = new String();
		String sb19 = new String();
		String sb20 = new String();
		String sb21 = new String();
		String sb22 = new String();

		if (share.getResultMark() != null) {
			sb1 = "resultMark=";
			sb2 = "'" + share.getResultMark() + "',";
		}
		if (share.getBen() != null) {
			sb3 = "ben=";
			sb4 = "'" + share.getBen() + "',";
		}
		if (share.getPm2_5() != null) {
			sb5 = "pm2_5=";
			sb6 = "'" + share.getPm2_5() + "',";
		}
		if (share.getSuggest() != null) {
			sb7 = "suggest=";
			sb8 = "'" + share.getSuggest() + "',";
		}
		if (share.getLng() != null) {
			sb9 = "ing=";
			sb10 = "'" + share.getLng() + "',";
		}
		if (share.getLat() != null) {
			sb11 = "lat=";
			sb12 = "'" + share.getLat() + "',";
		}
		if (share.getProvince() != null) {
			sb13 = "province=";
			sb14 = "'" + share.getProvince() + "',";
		}
		if (share.getDistrict() != null) {
			sb15 = "district=";
			sb16 = "'" + share.getDistrict() + "',";
		}
		if (share.getCity() != null) {
			sb17 = "city=";
			sb18 = "'" + share.getCity() + "',";
		}
		if (share.getStreet() != null) {
			sb19 = "street=";
			sb20 = "'" + share.getStreet() + "',";
		}
		if (share.getStreetNum() != null) {
			sb21 = "streetNum=";
			sb22 = "'" + share.getStreetNum() + "',";
		}
		String sresult = sb1 + "" + sb2 + "" + sb3 + "" + sb4 + "" + sb5 + "" + sb6 + "" + sb7 + "" + sb8 + "" + sb9
				+ "" + sb10 + "" + sb11 + "" + sb12 + "" + sb13 + "" + sb14 + "" + sb15 + "" + sb16 + "" + sb17 + ""
				+ sb18 + "" + sb19 + "" + sb20 + "" + sb21 + "" + sb22;
		String result = sresult.substring(0, sresult.length() - 1);
		sql = "update onekeySharedMessage set " + result + " where id = " + share.getId();
		boolean flag2 =  new DBOpreate().execute(sql);
		System.out.println(sql+flag2);
		if(flag2 == true){
			try {
				response.getWriter().print("success");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

		}
		return null;
	}
}
