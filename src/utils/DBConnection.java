package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnection {

	private static String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://"+NetConfig.IP+":"+NetConfig.PORT+";DatabaseName="+NetConfig.DateBaseName;
	
    private static String root=NetConfig.USERNAME;
    private static String password=NetConfig.PASSWORD;
    Connection conn;
   private static DBConnection DB;
    private  DBConnection()
    {
       try {
		Class.forName(Driver);
	    conn=DriverManager.getConnection(url, root, password);
       }catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
    }
    public static DBConnection getInstance()
    {
    	DB=new DBConnection();
    	
      return DB; 	
    }
    public  Connection getConnection()
    {
    	return conn;
    }

}
