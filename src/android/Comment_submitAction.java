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
 * �ύ���� ������
 */
public class Comment_submitAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
	HttpServletRequest request;
	HttpServletResponse response;
	private String userId;
	private String discmessage;
	private String sql;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDiscmessage() {
		return discmessage;
	}

	public void setDiscmessage(String discmessage) {
		this.discmessage = discmessage;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request = request;
	}

	public String execute() throws IOException {
		// ���Ȼ�ȡ����ID�Լ��û�ID
		userId = request.getParameter("");

		// Ȼ����в��Ҳ���
		sql = "";
		
		boolean flag = DBOpreate.execute(sql);
		this.response.setContentType("text/html");
		this.response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (flag == true) {
			out.print("���۳ɹ�");
		} else {
			out.print("����ʧ��");
		}
		return null;

	}

}
