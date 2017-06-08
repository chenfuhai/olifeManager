package android;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;



public class UserHead_updateAction extends ActionSupport {
	private String savePath;

	private File img;

	private String imgContentType;

	private String imgFileName;

	private String orderId;

	public String getSavePath() {
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}

	public File getImg() {
		return img;
	}

	public String getImgFileName() {
		return imgFileName;
	}

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public void setImgFileName(String imgFileName) {
		this.imgFileName = imgFileName;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public String getImgContentType() {
		return imgContentType;
	}

	public void setImgContentType(String imgContentType) {
		this.imgContentType = imgContentType;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	private String sql;

	public void upload() {
		String ct = ServletActionContext.getRequest().getHeader("Content-Type");
		System.out.println("Content-Type=" + ct);
		String result = "unknow error";
		System.out.println("orderId=" + getOrderId());
		FileOutputStream fos = null;
		FileInputStream fis = null;
		PrintWriter out = null;
		try {
			out = ServletActionContext.getResponse().getWriter();
			System.out.println(123);

			System.out.println(getSavePath() + "\\" + getImgFileName());
			File f1 = new File(getSavePath());
			if(!f1.exists()){
				f1.mkdirs();				
			}

			fos = new FileOutputStream(getSavePath() + "\\" + getImgFileName());
			fis = new FileInputStream(getImg());
			byte[] buffer = new byte[1024];
			int len = 0;
			while ((len = fis.read(buffer)) > 0) {
				fos.write(buffer, 0, len);
			}
			result = savePath + "/" + getImgFileName();
		} catch (Exception e) {
			result = "upload file failed ! ";
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(123);

		out.print(result);
		out.close();
	
	}
}
