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

import Dao.DaoClass;
import Service.ServiceClasss;
import dto.DtoClass;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          DtoClass dt=new DtoClass();
		          dt.setUserName(request.getParameter("login"));
		          dt.setUserPassword(request.getParameter("password"));
		            HttpSession ht=request.getSession();
		                ht.setAttribute("loginname",request.getParameter("login"));
		                ht.setAttribute("userpassword", request.getParameter("password"));
		         //       ht.invalidate();
		          ServiceClasss  sr=new ServiceClasss();
		             int flag= sr.Loginvalidity(dt);
		             if(flag==1)
	            	 {
	            	        
	            	  DaoClass dao=new DaoClass();
	            	   boolean n=dao.LoginData(dt);
	            	    if(n)
	            	    {    out.print("<h1>Wellcome"+request.getParameter("login"));
	            	    RequestDispatcher rd=request.getRequestDispatcher("/Home.html");
	            	    rd.include(request, response);  
	            	 }}
	             else{out.print("try again");
	             out.print(request.getParameter("useName"));  out.print(request.getParameter("userPass")); 
	             RequestDispatcher rd=request.getRequestDispatcher("login.html");
         	    rd.include(request, response);  
	           //  out.print(request.getParameter("userEmail")); out.print(request.getParameter("userCountry"));
	             }
	         
	}

}
