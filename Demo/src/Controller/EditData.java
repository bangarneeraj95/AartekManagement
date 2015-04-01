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


@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  PrintWriter out = response.getWriter();
	         response.setContentType("text/html");
	        
	         try {
	                   HttpSession ht=request.getSession();
	                      String flag=(String) ht.getAttribute("loginuser");
	                      out.println(flag);
	                      if(flag!=null){
	        	 String str1=request.getParameter("uname");  
	        	 DaoClass dao=new DaoClass();
	        	     ArrayList<DtoClass> al= dao.editData(str1);
	        	                         Iterator<DtoClass> it=al.iterator();
	        	                         out.println("you on Edit Form"+str1);
	         out.println("<form name='myform' action='UdateData' method='post' ");
	           out.println("<table border=1 width=50% height=50%>");
	   
	           while (it.hasNext())
	             {
	                    DtoClass n=  it.next() ;
	                    out.println(n.getUserName());
	                 out.println("<tr><td>UserName<input type='text' width='164' name='userName' value="+n.getUserName()+" /></br></br></td> </tr> ");
	                 out.println("<tr><td>UserPassword<input type='text' width='164' name='userPass' value="+n.getUserPassword()+" /></br></br></td> </tr>  ");
	                 out.println("<tr><td>UserEmail<input type='text' width='164' name='userEmail' value="+n.getUserEmail()+" /></br></br></td> </tr>  ");  
	                 out.println("<tr><td>UserCountry<input type='text' width='164' name='userCountry' value="+n.getUserCountry()+" /></br></br></td> </tr>  ");
	                 out.println("<tr><td><input type='submit'  value='Update'/></br></br></td> </tr>  ");
	         
	             }        out.println("</table>");
	             out.println("</html></body>");
	                      }
	             else{
	 	     		out.println("Pleaze Login First Then after View Data ");
	 	     		RequestDispatcher rd=request.getRequestDispatcher("login.html");
	 	         rd.include(request, response);  
	 	     	}
	            }
	             catch (Exception e) {
	             out.println(e);
	         }
	             
	         }
	         
	


}
