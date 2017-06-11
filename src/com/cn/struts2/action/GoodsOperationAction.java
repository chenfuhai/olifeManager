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

import entity.Goods;
import utils.DBOpreate;

public class GoodsOperationAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	private String goodsId,goodsName,goodsIconUrl,goodsDesc;
	private ArrayList<Goods> goodsData;
	
	public String goods_insert(){
		goodsName = request.getParameter("");
		goodsIconUrl = request.getParameter("");
		goodsDesc = request.getParameter("");
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		if (goodsName != null) {
			sb1.append("goodname").append(",");
			sb2.append("'" + goodsName + "'").append(",");
		}
		if (goodsIconUrl != null) {
			sb1.append("iconUrl").append(",");
			sb2.append("'" + goodsIconUrl + "'").append(",");
		}
		if (goodsDesc != null) {
			sb1.append("gooddesc").append(",");
			sb2.append("'" + goodsDesc + "'").append(",");
		}
		
		String result1 = sb1.toString().substring(0, sb1.toString().length()-1);
		String result2 = sb2.toString().substring(0, sb2.toString().length()-1);
		
		sql="select * from goods where goodname = '"+goodsName+"'";
		
		boolean flag1 = new DBOpreate().equals(sql);
		if(flag1 == true){
			//已经存在
			return ERROR;
			
		}else{
			sql="insert into goods("+result1+") values("+result2+")";
			boolean flag =  new DBOpreate().execute(sql);
			if(flag == true){
				//成功执行操作
				return SUCCESS;
			}
		}
		return null;
	}
	
	public String goods_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from goods";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		goodsData = new ArrayList<>();
		try {
			while(result.next()){
				Goods goods = new Goods();
				goods.setId(result.getInt("id"));
				goods.setName(result.getString("goodname"));
				goods.setDesc(result.getString("gooddesc"));
				goods.setIconUrl(result.getString("iconUrl"));
				goodsData.add(goods);
			}
			//将数据集合发送到jsp页面
			
			String data = gson.toJson(goodsData);
			try {
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
	
	public String goods_update(){
		//goodsName是修改名称后的值
		goodsId = request.getParameter("");
		goodsName = request.getParameter("");
		goodsIconUrl = request.getParameter("");
		goodsDesc = request.getParameter("");
		String sb1 = new String();
		String sb2 = new String();
		String sb3 = new String();
		String sb4 = new String();
		String sb5 = new String();
		String sb6 = new String();
		
		if(goodsName!=null){
			sb1="goodname=";
			sb2="'" + goodsName + "',";
		}
		if(goodsIconUrl!=null){
			sb3="iconUrl=";
			sb4="'" + goodsIconUrl + "',";
		}
		if(goodsDesc!=null){
			sb5="gooddesc=";
			sb6="'" + goodsDesc + "',";
		}
		String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+"";
		String result = sresult.substring(0, sresult.length()-1);
		sql="select * from goods where goodname = '"+goodsName+"'";
		ResultSet result1 = new DBOpreate().executeQuery(sql);
		if(result1 == null){
			//已经存在该名称,执行具体操作
			return ERROR;
		}else{
			sql="update goods set "+result+" where id = "+goodsId;
			boolean flag2 =  new DBOpreate().execute(sql);
			if(flag2 == true){
				return SUCCESS;
			}
		}
		
		return null;
	}
}
