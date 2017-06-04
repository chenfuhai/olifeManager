package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;
import utils.DBOpreate;
/**
 * 获取评论 需完善
 */
public class Comment_getAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	HttpServletRequest request;
	HttpServletResponse response;
	
	private String discId;
	private String sharedMessageId;
    private String userId;
    private String userImgUrl;
    private String username;
    private Boolean usersex;
    private String userage;   
    private String message;
    private String sql;
    
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getDiscId() {
		return discId;
	}

	public void setDiscId(String discId) {
		this.discId = discId;
	}

	public String getSharedMessageId() {
		return sharedMessageId;
	}

	public void setSharedMessageId(String sharedMessageId) {
		this.sharedMessageId = sharedMessageId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserImgUrl() {
		return userImgUrl;
	}

	public void setUserImgUrl(String userImgUrl) {
		this.userImgUrl = userImgUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Boolean getUsersex() {
		return usersex;
	}

	public void setUsersex(Boolean usersex) {
		this.usersex = usersex;
	}

	public String getUserage() {
		return userage;
	}

	public void setUserage(String userage) {
		this.userage = userage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
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
		
		
		
		
		//然后进行查找操作
		sql="";
		ResultSet result = DBOpreate.executeQuery(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if(result != null){
			try {
				JSONObject array = new JSONObject();
				array.put("userName", result.getString("userName"));
				array.put("userImgUrl", result.getString("userImgUrl"));
				array.put("usersex", result.getString("usersex"));
				array.put("message", result.getString("message"));
				
				out.print(array.toString());
				out.flush();
				System.out.println("获取评论成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			out.print("获取评论失败");
			out.flush();
		}
		return null;	
	}

}
