package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;


public class ShareOperationAction extends ActionSupport{
	private String messageId;
	private Integer resultMark;
	private Integer ben;
	private Integer pm2_5;
	private String suggest;
	private String userId;
	private Double lng;
	private Double lat;
	private String province;
	private String district;
	private String city;
	private String street;
	private String StreetNum;
	private String sql;
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	
	public String Share_show(){
		sql="select * from onekeySharedMessage";
		ResultSet flag =  new DBOpreate().executeQuery(sql);
		if(flag != null){
		
		}
		return null; 
	}
	
	
	public String Share_dalete(){
		sql="delete from onekeySharedMessage where messageid = '" + messageId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			
		}
		return null;
	}	
	
	public String Share_update(){
		sql="update onekeySharedMessage set resultMark = '"+resultMark+"'and ben = '"+ben+"'and pm2_5 = '"+pm2_5+"'and suggest = '"+suggest+"'"
				+ "and ing = '"+lng+"'and lat = '"+lat+"'and province = '"+province+"'"
						+ "and district = '"+district+"'and city = '"+city+"'and street = '"+street+"'"
								+ "and streetNum = '"+StreetNum+"'where messageid = '"+messageId+"'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
			
		}
		return null;
	}
}
