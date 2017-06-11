package android;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
import utils.JudgeSQL;
import utils.NetUtils;
import utils.Query;

public class Goods_queryAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private String sql;

	public String execute() throws IOException {
		String msg = NetUtils.readString(ServletActionContext.getRequest().getInputStream());
		Gson gson = new GsonBuilder().serializeNulls().create();
		Query query = gson.fromJson(msg, Query.class);
		sql = JudgeSQL.jSQL("goods",null,null, query.getLimit(), query.getOrder(), query.getSkip());
	
		ResultSet result = new DBOpreate().executeQuery(sql);
		ArrayList<Goods> goods = new ArrayList<>();
		try {
			while(result.next()){
				Goods good = new Goods();
				good.setId(result.getInt("id"));
				good.setDesc(result.getString("gooddesc"));
				good.setName(result.getString("goodname"));
				good.setIconurl(result.getString("iconUrl"));
				goods.add(good);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String data = gson.toJson(goods);
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8;");
		response.getWriter().println(data);
		
		return null;
	}

}
