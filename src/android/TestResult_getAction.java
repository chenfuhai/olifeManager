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

public class TestResult_getAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
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

	public String execute() throws IOException {
		// 获取用户ID
		userId = request.getParameter("");
		sql = "";

		ResultSet result = DBOpreate.executeQuery(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (result != null) {
			try {
				JSONObject array = new JSONObject();
				array.put("resultMark", result.getString(""));
				array.put("Ing", result.getString(""));
				array.put("lat", result.getString(""));
				out.print(array);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			out.print("数据保存失败");
		}
		return null;
	}
}
