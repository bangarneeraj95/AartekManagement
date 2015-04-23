package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoClass;
import dto.DtoClass;


@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out = response.getWriter();
	         response.setContentType("text/html");
	         out.println("<html><body>");
	         out.print("hello");
	         HttpSession ht=request.getSession();
             String flag=(String) ht.getAttribute("loginuser");
             out.println("hello");
             out.println(flag);
             if(flag!=null){
	         try {
	        	      DaoClass dao=new DaoClass();
	        	     ArrayList<DtoClass> al= dao.dispalyData();
	        	                         Iterator<DtoClass> it=al.iterator();
	             out.println("<table border=1 width=50% height=50%>");
	             out.println("<tr><th>UserName</th><th>UserPassword</th><th>EmailId</th><th>userCountry</th><th>Edit</th><tr>");
	             while (it.hasNext())
	             {
	                    DtoClass n=it.next() ;
	                
	       	                 out.println("<tr><td>" + n.getUserName() + "</td><td>" + n.getUserPassword() + "</td><td>" + n.getUserEmail() + "</td><td>" + n.getUserCountry() + "</td> "); 
	            	String s1=n.getUserName();
	       	                 out.println(" <td> <div> <a href='http://localhost:7070/Demo/EditData?uname="+s1+"'>Edit</a> </div> </td>");
	             }
	             out.println("</table>");
	             out.print("hello");
	             out.println("</html></body>");
	          
	            }
	             catch (Exception e) {
	             out.println(e);
	         }
	}

	else{
		out.println("Pleaze Login First Then after View Data ");
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
    rd.include(request, response);  
	}
	} 
}
