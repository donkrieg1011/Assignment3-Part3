package dbAccess;

import java.io.IOException;
import java.sql.SQLException;

import dbAccess.LoginConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginChecking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private LoginConnection newConn;
    
    public LoginChecking() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		
		try {
			newConn = new LoginConnection();
			if (newConn.searchUsers(uname, password)) {
				response.sendRedirect("LoginSuccess.jsp");
			}
		
			else {
				try {
					boolean result = newConn.searchUsers(uname, password);
				
					if (result == true) {
						response.sendRedirect("LoginSuccess.jsp");
					}
					else {
						response.sendRedirect("LoginFail.jsp");
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
