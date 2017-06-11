package com.cn.struts2.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import entity.Goods;
import utils.DBOpreate;

public class GoodsOperationAction extends ActionSupport{
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpServletResponse response = ServletActionContext.getResponse();
	private String sql;
	private String goodsId,goodsName,goodsIconUrl,goodsDesc;
	private ArrayList<Goods> goodsData;
	
	public String goods_insert(){
		goodsName = request.getParameter("");
		goodsIconUrl = request.getParameter("");
		goodsDesc = request.getParameter("");
		
		sql="select * from goods where goodname = '"+goodsName+"'";
		boolean flag1 = new DBOpreate().equals(sql);
		if(flag1 == true){
			//已经存在
			
		}else{
			sql="insert into goods(goodname,iconUrl,gooddesc) values('"+goodsName+"','"+goodsIconUrl+"','"+goodsDesc+"')";
			boolean flag =  new DBOpreate().execute(sql);
			if(flag == true){
				//成功执行操作
			}
		}
		
		return null;
	}
	
	public String goods_show(){
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
			ActionContext.getContext().put("goodsData", goodsData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String goods_delete(){
		goodsId = request.getParameter("");
		sql="delete from goods where id = '" + goodsId + "'";
		boolean flag =  new DBOpreate().execute(sql);
		if(flag == true){
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
				ActionContext.getContext().put("goodsData", goodsData);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
		return null;
	}
	
	public String goods_update(){
		//goodsName是修改名称后的值
		goodsId = request.getParameter("");
		goodsName = request.getParameter("");
		goodsIconUrl = request.getParameter("");
		goodsDesc = request.getParameter("");
		sql="select * from goods where goodname = '"+goodsName+"'";
		boolean flag1 = new DBOpreate().equals(sql);
		if(flag1 == true){
			//已经存在该名称,执行具体操作
		}else{
			sql="update goods set goodname = '"+goodsName+"' and iconUrl = '"+goodsIconUrl+"' and gooddesc = '"+goodsDesc+"' where id = '"+goodsId+"'";
			boolean flag2 =  new DBOpreate().execute(sql);
			if(flag2 == true){
				
			}
		}
		
		return null;
	}
}
