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
 * ��ȡ��Ʒ��������Ϣ
 * ����httpЭ��
 * ���ýӿ�ע��ķ�ʽע��HttpServletRequest,HttpServletResponse����
 */
public class Goods_getAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	
	private static final long serialVersionUID = 1L;
	//����httpЭ���ȡ������������
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
		
		// �������ݿⲢ���в��Ҳ����������ص����������
		ResultSet result = DBOpreate.executeQuery(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (result != null) {
			//����json�洢��������
			JSONObject array = new JSONObject();
			try {
				
				array.put("icon", result.getString("icon"));
				array.put("goodId", result.getString("goodId"));
				array.put("goodName", result.getString("goodName"));
				array.put("desc", result.getString("desc"));
				
				out.print(array.toString());
				System.out.println("��Ʒ��Ϣ��ȡ�ɹ�");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return null;
	}

}
