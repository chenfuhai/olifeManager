package utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * �������ݿ�Ĳ��� ��ѯ ִ�����
 * @author chenfuhai
 *
 */
public class DBOpreate {
    private static DBConnection db;
	private static Connection conn;
	private static Statement state;
	private static ResultSet rs;

	private static void init(){
		try {
			db=DBConnection.getInstance();
			conn=db.getConnection();
			state=conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static ResultSet executeQuery(String sql){
		init();
		ResultSet resultSet = null;
		 try {
				resultSet  = rs=state.executeQuery(sql);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return resultSet;
	}
	public static boolean execute(String sql){
		init();
		boolean flag = false;
		try {
			state.execute(sql);
			flag = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			flag = false;
			e.printStackTrace();
		}finally {
			DBOpreate.closeAllConnection();
		}
		return flag;
		
	}
	public static void closeAllConnection(){
		
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
