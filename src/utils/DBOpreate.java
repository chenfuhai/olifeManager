package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class DBOpreate {
    private  DBConnection db;
	private  Connection conn;
	private  Statement state;
	private  ResultSet rs;

	private  void init(){
		try {
			db=DBConnection.getInstance();
			conn=db.getConnection();
			state=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  ResultSet executeQuery(String sql){
		init();
		
		 try {
				rs=state.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	public  boolean execute(String sql){
		init();
		boolean flag = false;
		try {
			state.execute(sql);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}
		return flag;
		
	}
	public  void closeAllConnection(){
		
		try {
			if (rs.isClosed()) {
				rs.close();				
			}
			if (!state.isClosed()) {
				state.close();				
			}
			if (!conn.isClosed()) {
				conn.close();				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
