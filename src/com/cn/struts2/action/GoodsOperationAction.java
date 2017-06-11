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
import com.opensymphony.xwork2.ActionSupport;

import entity.Goods;
import utils.DBOpreate;
import utils.NetUtils;

public class GoodsOperationAction extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	
	private ArrayList<Goods> goodsData;
	
	public String goods_insert(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		Goods good = gson.fromJson(msg, Goods.class);
		System.out.println(msg);
		
		
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		
		if (good.getName() != null) {
			sb1.append("goodname").append(",");
			sb2.append("'" + good.getName() + "'").append(",");
		}
		if (good.getIconurl() != null) {
			sb1.append("iconUrl").append(",");
			sb2.append("'" + good.getIconurl() + "'").append(",");
		}
		if (good.getDesc() != null) {
			sb1.append("gooddesc").append(",");
			sb2.append("'" + good.getDesc() + "'").append(",");
		}
		if (good.getUrl() != null) {
			sb1.append("goodUrl").append(",");
			sb2.append("'" + good.getUrl() + "'").append(",");
		}
		
		String result1 = sb1.toString().substring(0, sb1.toString().length()-1);
		String result2 = sb2.toString().substring(0, sb2.toString().length()-1);
		
		sql="select * from goods where goodname = '"+good.getName()+"'"+"order by id desc";
		
		
		ResultSet resultSet=new DBOpreate().executeQuery(sql);
		
		try {
			if(resultSet.next()){
				try {
					response.getWriter().print("failed");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return null;
				
			}else{
				sql="insert into goods("+result1+") values("+result2+")";
				boolean flag =  new DBOpreate().execute(sql);
				if(flag == true){
					try {
						response.getWriter().print("success");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String goods_show(){
		Gson gson = new GsonBuilder().create();
		sql="select * from goods order by id desc";
		ResultSet result =  new DBOpreate().executeQuery(sql);
		goodsData = new ArrayList<>();
		try {
			while(result.next()){
				Goods goods = new Goods();
				goods.setId(result.getInt("id"));
				goods.setName(result.getString("goodname"));
				goods.setDesc(result.getString("gooddesc"));
				goods.setIconurl(result.getString("iconUrl"));
				goods.setUrl(result.getString("goodUrl"));
				goodsData.add(goods);
			}
			//将数据集合发送到jsp页面
			
			String data = gson.toJson(goodsData);
			
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
	
	public String goods_update(){
		String msg = null;
		try {
			msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Gson gson = new GsonBuilder().serializeNulls().create();
		Goods good = gson.fromJson(msg, Goods.class);
		System.out.println(msg);
		
		String sb1 = new String();
		String sb2 = new String();
		String sb3 = new String();
		String sb4 = new String();
		String sb5 = new String();
		String sb6 = new String();
		String sb7 = new String();
		String sb8 = new String();
		
		if(good.getName()!=null){
			sb1="goodname=";
			sb2="'" + good.getName() + "',";
		}
		if(good.getIconurl()!=null){
			sb3="iconUrl=";
			sb4="'" + good.getIconurl() + "',";
		}
		if(good.getDesc()!=null){
			sb5="gooddesc=";
			sb6="'" + good.getDesc() + "',";
		}
		if(good.getUrl()!=null){
			sb7="goodUrl=";
			sb8="'" + good.getUrl() + "',";
		}
		String sresult = sb1+""+sb2+""+sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+"";
		String result = sresult.substring(0, sresult.length()-1);
		sql="select * from goods where id = '"+good.getId()+"'";
		ResultSet result1 = new DBOpreate().executeQuery(sql);
		try {
			if(!result1.next()){
				//不已经存在该名称,不能插入
				response.getWriter().print("failed");
				return null;
			}else{
				sql="update goods set "+result+" where id = "+good.getId();
				boolean flag2 =  new DBOpreate().execute(sql);
				if(flag2 == true){
					response.getWriter().print("success");
					return null;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
