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
 * 获取商品的数据信息
 * 利用http协议
 * 采用接口注入的方式注入HttpServletRequest,HttpServletResponse对象
 */
public class Goods_getAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private static final long serialVersionUID = 1L;
	//利用http协议获取服务器端数据
	HttpServletRequest request;
    HttpServletResponse response;
	
	private String icon;
	private String goodId;
	private String goodName;
	private String desc;
	private String sql = "select * from goods";

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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String execute() throws IOException {
		
		// 连接数据库并进行查找操作，将返回的数据流存放
		ResultSet result = DBOpreate.executeQuery(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (result != null) {
			//利用json存储传递数据
			JSONObject array = new JSONObject();
			try {
				
				array.put("icon", result.getString("icon"));
				array.put("goodId", result.getString("goodId"));
				array.put("goodName", result.getString("goodName"));
				array.put("desc", result.getString("desc"));
				
				out.print(array.toString());
				System.out.println("商品信息获取成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
