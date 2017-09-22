package testPackage;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dbAccess.CarInfo;
import junit.framework.TestCase;

public class TestClass extends TestCase {
	CarInfo testCar;
	Date startTime;
	Date endTime;
	
	public TestClass( ) {
	}
	
	@Before
    public void setUp() {
		String inputString1 = "09:00";
		String inputString2 = "11:00";
		DateFormat dateFormat = new SimpleDateFormat("HH:MM");
		try {
			startTime = dateFormat.parse(inputString1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			endTime = dateFormat.parse(inputString2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
        testCar = new CarInfo("1234", "472 Jackson Street", "Monday", startTime, endTime, false, false, 3);
    }
    
    @Test
    public void testGetTimeDiff() {
        assertEquals(2.0, testCar.getTimeDiff());
    }
    
    public void testCheckFeesPaid() {
    	assertTrue(testCar.checkFeesPaid());
    }
    
    public void testCheckTimeLimit() {
    	try {
			assertTrue(testCar.checkTimeLimit());
		} catch (ParseException e) {
			e.printStackTrace();
		}
    }
}
