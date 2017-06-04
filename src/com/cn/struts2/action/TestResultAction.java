package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;

public class TestResultAction extends ActionSupport{
	private String recordId;
	private String userId;
	private String resultMark;
    private Double lng;
    private Double lat;
    private String sql;
	public String getRecordId() {
		return recordId;
	}
	public void setRecordId(String recordId) {
		this.recordId = recordId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getResultMark() {
		return resultMark;
	}
	public void setResultMark(String resultMark) {
		this.resultMark = resultMark;
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
    
	/**
	 * 显示
	 */
	public String TestResult_show(){
		sql="select * from onekeyResultRecord";
		ResultSet flag = DBOpreate.executeQuery(sql);
		if(flag != null){
			//执行具体操作
		}
		return null; 
	}
	/**
	 * 删除
	 */
	public String TestResult_dalete(){
		sql="delete from onekeyResultRecord where recordId = '" + recordId + "'";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			//执行具体操作
		}
		return null;
	}
}
