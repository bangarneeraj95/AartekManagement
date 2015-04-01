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
import dto.DtoClass;
@WebServlet("/UdateData")
public class UdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  PrintWriter out = response.getWriter();
	         response.setContentType("text/html");
	         HttpSession ht=request.getSession();
             String flag1=(String) ht.getAttribute("loginuser");
             out.println(flag1);
             if(flag1!=null){
	            DtoClass dt=new DtoClass();
	          dt.setUserName(request.getParameter("userName"));
	        //  out.println(request.getParameter("userName"));
	          dt.setUserPassword(request.getParameter("userPass"));
	          dt.setUserEmail(request.getParameter("userEmail"));
	          dt.setUserCountry(request.getParameter("userCountry"));
	          
     // 
         DaoClass dao=new DaoClass();
         int flag= dao.updateData(dt);
       //  out.println(flag);
	        //	 RequestDispatcher rd=request.getRequestDispatcher("/View.html");
	             // 	    rd.include(request, response);  
	         if(flag>=1){
	          out.println("<html><body>"+flag+"<h1>succesfull update");
	          RequestDispatcher rd=request.getRequestDispatcher("/View.html");
      	    rd.include(request, response);  
	         }
	          else
	        	 out.println("<html><body><h1>Unsuccesfull update");
             }
             else{
         		out.println("Pleaze Login First Then after Update Data ");
         		RequestDispatcher rd=request.getRequestDispatcher("login.html");
             rd.include(request, response);  
         	}
	}

}
