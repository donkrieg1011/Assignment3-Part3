package dbAccess;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarInfo {
	private static String carNumber;
	private static String parkAddress;
	private static String day;
	private static Date startTime;
	private static Date endTime;
	private static boolean handicapPermit; 
	private static boolean handicappedSpot;
	private static double paidFee; 
	private static boolean parkedIllegally;
	
	public CarInfo(String myCarNum, String myAdd, String myDay, Date myStart, Date myEnd, boolean myHandPermit, boolean isHandicapped, double myFee) {
		this.carNumber = myCarNum;
		this.parkAddress = myAdd;
		this.day = myDay;
		this.startTime = myStart;
		this.endTime = myEnd;
		this.handicapPermit = myHandPermit;
		if (handicapPermit == true && isHandicapped == true) {
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

	public static String getDay() {
		return day;
	}

	public static void setDay(String day) {
		CarInfo.day = day;
	}

	public static Date getStartTime() {
		return startTime;
	}

	public static void setStartTime(Time startTime) {
		CarInfo.startTime = startTime;
	}

	public static Date getEndTime() {
		return endTime;
	}

	public static void setEndTime(Time endTime) {
		CarInfo.endTime = endTime;
	}

	public static boolean getIsHandicapPermit() {
		return handicapPermit;
	}

	public void setHandicapPermit(boolean handicapPermit) {
		this.handicapPermit = handicapPermit;
	}

	public static boolean getIsHandicappedSpot() {
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
	
	public static Boolean checkFeesPaid() {
		if (getPaidFee() >= getTimeDiff() * 1.5) {
			return true;
		} else {
			//parkedIllegally = true;
			return false;
		}
	}
	
	public static long getTimeDiff() {
		long diff = endTime.getTime() - startTime.getTime();
		long diffMinutes = diff / (60 * 1000);         
		long diffHours = diff / (60 * 60 * 1000); 
		return diffHours;
	}
	
	public static Boolean checkTimeLimit() throws ParseException {
		SimpleDateFormat parser = new SimpleDateFormat("HH:MM");
		Date nine = parser.parse("09:00");
		Date five = parser.parse("17:00");
		long beforeNine = startTime.getTime() - nine.getTime();
		long afterFive = five.getTime() - endTime.getTime();
		
		if ((beforeNine < 0 || afterFive < 0) && (!getDay().equals("Saturday") || !getDay().equals("Sunday"))) {
			//parkedIllegally = true;
			System.out.println(beforeNine);
			System.out.println(afterFive);
			System.out.println(!getDay().equals("Saturday"));
			System.out.println(!getDay().equals("Sunday"));
			return false;
		}
		else return true;
	}
}
