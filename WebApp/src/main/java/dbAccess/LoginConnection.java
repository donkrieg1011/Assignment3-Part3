package dbAccess;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class LoginConnection {
	private Connection myConn;
	private StringBuilder list;
	
	public LoginConnection() throws Exception {		
	    String hostName = "localhost";
		String user = "root";
		String password = "1234";
		String dbName = "user_login";
		String dburl = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useSSL=false";;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("Successful connection to: " + dburl);
	}
	
	
	public boolean searchUsers(String username, String password) throws Exception {
		 
		PreparedStatement myStmt = null;
		ResultSet myRs = null;

		try {
			myStmt = myConn.prepareStatement("select * from user_info");
			
			myRs = myStmt.executeQuery();
			myRs.beforeFirst();
			while (myRs.next()) {
				String myUsername = myRs.getString("username");
	            String myPassword = myRs.getString("password");
	            
	            if (myUsername.equals(username) && myPassword.equals(password))
	            {
	            	return true;
	            }
	            else {
	            	return false;
	            }
	    		
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			myConn.close();
		}
		return false;
	
	}
}
