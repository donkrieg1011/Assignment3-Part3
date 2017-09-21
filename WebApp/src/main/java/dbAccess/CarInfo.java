package dbAccess;

import java.sql.Time;
import java.util.Date;

public class CarInfo {
	private static String carNumber;
	private static String parkAddress;
	private static Date day;
	private static Time startTime;
	private static Time endTime;
	private boolean handicapPermit; 
	private boolean handicappedSpot;
	private static double paidFee; 
	private int timeParked;
	private double owedFee;
	private boolean parked_illegally;
	
	public CarInfo(String myCarNum, String myAdd, Date myDay, Time myStart, Time myEnd, boolean myHandPermit, boolean isHandicapped, double myFee) {
		this.carNumber = myCarNum;
		this.parkAddress = myAdd;
		this.day = myDay;
		this.startTime = myStart;
		this.endTime = myEnd;
		this.handicapPermit = myHandPermit;
		if (handicapPermit == true) {
			this.handicappedSpot = true;
		}
		else this.handicappedSpot = false;
		this.paidFee = myFee;
	}

	public static String getCarNumber() {
		return carNumber;
	}

	public static void setCarNumber(String carNumber) {
		CarInfo.carNumber = carNumber;
	}

	public static String getParkAddress() {
		return parkAddress;
	}

	public static void setParkAddress(String parkAddress) {
		CarInfo.parkAddress = parkAddress;
	}

	public static Date getDay() {
		return day;
	}

	public static void setDay(Date day) {
		CarInfo.day = day;
	}

	public static Time getStartTime() {
		return startTime;
	}

	public static void setStartTime(Time startTime) {
		CarInfo.startTime = startTime;
	}

	public static Time getEndTime() {
		return endTime;
	}

	public static void setEndTime(Time endTime) {
		CarInfo.endTime = endTime;
	}

	public boolean isHandicapPermit() {
		return handicapPermit;
	}

	public void setHandicapPermit(boolean handicapPermit) {
		this.handicapPermit = handicapPermit;
	}

	public boolean isHandicappedSpot() {
		return handicappedSpot;
	}

	public void setHandicappedSpot(boolean handicappedSpot) {
		this.handicappedSpot = handicappedSpot;
	}

	public static double getPaidFee() {
		return paidFee;
	}

	public static void setPaidFee(double paidFee) {
		CarInfo.paidFee = paidFee;
	}
	
	
}
