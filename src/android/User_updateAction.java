package android;

import java.io.IOException;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.User;
import utils.DBOpreate;
import utils.NetUtils;

public class User_updateAction extends ActionSupport{
	private String sql;
	public String execute() throws IOException{
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		User user = gson.fromJson(msg, User.class);
		// 声明两个StringBuffer，sb1存列名，sb2存数据
		
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
		// 对列中的数据进行判断
		
		if (user.getUsername() != null) {
			sb3="username=";
			sb4="'" + user.getUsername() + "',";
		}
		if (user.getPhone() != null) {
			sb5="phone=";
			sb6="'" + user.getPhone() + "',";
		}
		if (user.getSex() != null) {
			sb7="sex=";
			sb8="'" + user.getSex() + "',";
		}
		
		if (user.getBrithday() != null) {
			sb9="brithday=";
			sb10="'" + user.getBrithday() + "',";
		}
		if (user.getEmail() != null) {
			sb11="email=";
			sb12="'" + user.getEmail() + "',";
		}
		if (user.getImgUrl() != null) {
			sb13="imgUrl=";
			sb14="'" + user.getImgUrl() + "',";
		}
		if(user.getAge()!=null){
			sb15="age=";
			sb16="'" + user.getAge() + "',";
		}
		String sresult = sb3+""+sb4+""+sb5+""+sb6+""+sb7+""+sb8+""+sb9+""+sb10+""+sb11+""+sb12+""+sb13+""+sb14+""+sb15+""+sb16;
		String result = sresult.substring(0, sresult.length()-1);
	
		sql = "update ouser set "+result+" where id = "+user.getId();
		
		boolean flag = DBOpreate.execute(sql);

		if (flag == true) {
			ServletActionContext.getResponse().getWriter().println("success");
		} else {
			ServletActionContext.getResponse().getWriter().println("failed");
		}
		return null;
	}
}
