package dbAccess;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CarConnection {
	private Connection myConn;
	private StringBuilder list;
	
	public CarConnection() throws Exception {		
	    String hostName = "localhost";
		String user = "root";
		String password = "1234";
		String dbName = "parking_info";
		String dburl = "jdbc:mysql://" + hostName + ":3306/" + dbName + "?autoReconnect=true&useSSL=false";;
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		myConn = DriverManager.getConnection(dburl, user, password);
		System.out.println("Successful connection to: " + dburl);
	}
	
	public void addEntry(CarInfo newCar) throws Exception {
		PreparedStatement myStmt = null;

		myStmt = myConn.prepareStatement("insert into car_info"
				+ " (car_number, address, day, total_time, handicap_permit, is_handicapped, fee)"
				+ " values (?, ?, ?, ?, ?, ?, ?)");
		
		try {
			myStmt.setString(1, CarInfo.getCarNumber());
			myStmt.setString(2, CarInfo.getParkAddress());
			myStmt.setString(3, CarInfo.getDay());
			myStmt.setDouble(4, CarInfo.getTimeDiff());
			myStmt.setBoolean(5, CarInfo.getIsHandicapPermit());
			myStmt.setBoolean(6, CarInfo.getIsHandicappedSpot());
			myStmt.setDouble(7, CarInfo.getPaidFee());

			myStmt.executeUpdate();	
			
		}
		finally {
			myConn.close();
		}
	}
}
