package dbAccess;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CarCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarConnection newConn;
       
    public CarCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carNumber = request.getParameter("car_rego");
		String parkAddress = request.getParameter("park_address");
		String day = request.getParameter("day");
		SimpleDateFormat sdf = new SimpleDateFormat("HH:MM");
		Date startTime = null, endTime = null;
		try {
			startTime = sdf.parse(request.getParameter("start_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			endTime = sdf.parse(request.getParameter("end_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Time startTime = Time.parse(request.getParameter("start_time"));
		//Time endTime = request.getParameter("end_time");
		String permit = request.getParameter("is_handicapped"); 
		String spot = request.getParameter("handicapped_spot");
		boolean handicappedPermit;
		boolean handicappedSpot;
		if(permit.equals("Y")) handicappedPermit = true;
		else handicappedPermit = false;
		if(spot.equals("Y")) handicappedSpot = true;
		else handicappedSpot = false;
		double paidFee = Double.parseDouble(request.getParameter("fees_paid")); 
		CarInfo newCar = new CarInfo(carNumber, parkAddress, day, startTime, endTime, handicappedPermit, handicappedSpot, paidFee);
		
		boolean timeLimit = true;
		try {
			timeLimit = newCar.checkTimeLimit();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("Time Limit: " + timeLimit);
		
	
		int overtime = 0, wrongTime = 0, rippedOff = 0, hasNotPaid = 0;
		request.setAttribute("overtime", overtime);
		request.setAttribute("wrongTime", wrongTime);
		request.setAttribute("rippedOff", rippedOff);
		request.setAttribute("hasNotPaid", hasNotPaid);
		if(carNumber.equals("") || parkAddress.equals("") || day.equals("") || startTime == null || endTime == null || permit.equals("") || spot.equals("") || (Double)paidFee == null){
			RequestDispatcher view = request.getRequestDispatcher("/EntryFail.jsp");
			view.forward(request, response);
		}
		else if(newCar.getTimeDiff() > 2 && !day.equals("Sunday")){
			overtime = 1;
			request.setAttribute("overtime", overtime);
			RequestDispatcher view = request.getRequestDispatcher("/EntryFail.jsp");
			view.forward(request, response);
		}
		else if(timeLimit == false){
			wrongTime = 1;
			request.setAttribute("wrongTime", wrongTime);
			RequestDispatcher view = request.getRequestDispatcher("/EntryFail.jsp");
			view.forward(request, response);
		}
		else if(newCar.checkFeesPaid() == true && day.equals("Saturday")){
			rippedOff = 1;
			request.setAttribute("rippedOff", rippedOff);
			RequestDispatcher view = request.getRequestDispatcher("/EntryFail.jsp");
			view.forward(request, response);
		}
		else if(newCar.checkFeesPaid() == false && !day.equals("Saturday")){
			hasNotPaid = 1;
			request.setAttribute("hasNotPaid", hasNotPaid);
			RequestDispatcher view = request.getRequestDispatcher("/EntryFail.jsp");
			view.forward(request, response);
		}
		
		
		else{
			try {
				newConn = new CarConnection();
				newConn.addEntry(newCar);
				//go to entry S U C C here
				response.sendRedirect("EntrySuccess.jsp");
				
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//		try {
//			newConn = new CarConnection();
//			if (newConn.searchUsers(uname, password)) {
//				response.sendRedirect("Entry.jsp");
//			}
//		
//			else {
//				try {
//					boolean result = newConn.searchUsers(uname, password);
//				
//					if (result == true) {
//						response.sendRedirect("Entry.jsp");
//					}
//					else {
//						response.sendRedirect("LoginFail.jsp");
//					}
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
