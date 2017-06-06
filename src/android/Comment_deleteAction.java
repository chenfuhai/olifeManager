package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.OnekeySharedDisc;
import utils.DBOpreate;
import utils.Delete;
import utils.NetUtils;

public class Comment_deleteAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().create();
		Delete delete = gson.fromJson(msg,Delete.class);
		sql="delete from '"+delete.getTableName()+"'";
		boolean flag = DBOpreate.execute(sql);
		if(flag == true){
			ServletActionContext.getResponse().getWriter().println("success");
		}else{
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
