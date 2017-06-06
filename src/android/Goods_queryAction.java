package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import entity.Goods;
import net.sf.json.JSONObject;
import utils.DBOpreate;
import utils.NetUtils;
import utils.Query;
/**
 * 获取商品的数据信息
 * 利用http协议
 * 
 */
public class Goods_queryAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	//利用http协议获取服务器端数据
	private String sql;

	public String execute() throws IOException {
		//获取安卓端传送过来的数据值
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		//以gson形式将数据中的条件取出
		Query query = gson.fromJson(msg, Query.class);
		sql = "select * from '"+query.getTableName()+"'";
		// 连接数据库并进行查找操作，将返回的数据流存放
		ResultSet result = DBOpreate.executeQuery(sql);
		if (result != null) {
			//构造的Goods类
			Goods goods = new Goods();
			try {	
				goods.setId(Integer.parseInt(result.getString("goodid")));
				goods.setDesc(result.getString("gooddesc"));
				goods.setName(result.getString("goodname"));
				goods.setIconUrl(result.getString("iconUrl"));
				String data = gson.toJson(goods);
				ServletActionContext.getResponse().getWriter().println(data);
				System.out.println("商品信息获取成功");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
