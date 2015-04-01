package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  HttpSession ht=request.getSession();
		  response.setContentType("text/html");  
			PrintWriter out = response.getWriter();  
			out.println("<html><body><h2>You Sucessfull Logout    "+ht.getAttribute("loginname"));
		 // ht.grtAttribute("loginname");
       //  ht.setAttribute("userpassword", request.getParameter("password"));
			      ht.invalidate();
			   
			
				 RequestDispatcher rd=request.getRequestDispatcher("login.html");
				    rd.include(request, response);  
				    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
			        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
			        response.setDateHeader("Expires", 0);
			
		
  
    
	}

}
