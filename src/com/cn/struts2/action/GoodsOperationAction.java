package com.cn.struts2.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;
/**
 * ����Ʒ��Ϣ���й���
 * @author wuguofei
 *
 */
public class GoodsOperationAction extends ActionSupport{
	private String icon;
	private String goodId;
	private String goodName;
	private String desc;
	private String sql;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getGoodName() {
		return goodName;
	}
	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	/**
	 * �ϴ�
	 * @return
	 */
	public String goods_insert(){
		sql="insert into goods(goodid,goodname,iconUrl,gooddesc) values('"+goodId+"','"+goodName+"','"+icon+"','"+desc+"')";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			//ִ�о������
		}
		return null;
	}
	/**
	 * ��ʾ
	 */
	public String goods_show(){
		sql="select * from goods";
		ResultSet flag = DBOpreate.executeQuery(sql);
		if(flag != null){
			//ִ�о������
		}
		return null;
	}
	/**
	 * ɾ��
	 * @return
	 */
	public String goods_delete(){
		sql="delete from goods where goodid = '" + goodId + "'";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			//ִ�о������
		}
		return null;
	}
	/**
	 * ����
	 * @return
	 */
	public String goods_update(){
		sql="update goods set goodname = '"+goodName+"'and iconUrl = '"+icon+"'and gooddesc = '"+desc+"' where goodid = '"+goodId+"'";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			//ִ�о������
		}
		return null;
	}
}
