package android;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import utils.DBOpreate;
/**
 * 保存测试结果 需完善
 */
public class TestResult_saveAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	HttpServletRequest request;
	HttpServletResponse response;
	private String resultMark;
	private String userId;
	private String Ing;
	private String Lat;
	private String sql;
	
	public String getResultMark() {
		return resultMark;
	}
	public void setResultMark(String resultMark) {
		this.resultMark = resultMark;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIng() {
		return Ing;
	}
	public void setIng(String ing) {
		Ing = ing;
	}
	public String getLat() {
		return Lat;
	}
	public void setLat(String lat) {
		Lat = lat;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}
	public String execute() throws IOException{
		
		sql="";
		
		boolean flag = DBOpreate.execute(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(flag == true){
			out.print("数据保存成功");
		}else{
			out.print("数据保存失败");
		}
		return null;
	}
}
