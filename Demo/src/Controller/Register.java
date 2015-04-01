package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.DtoClass;
import Dao.DaoClass;
import Service.ServiceClasss;

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");  
		PrintWriter out = response.getWriter();  
		          DtoClass dt=new DtoClass();
		          dt.setUserName(request.getParameter("userName"));
		        //  out.print(request.getParameter("userName"));
		          dt.setUserPassword(request.getParameter("userPass"));
		          dt.setUserEmail(request.getParameter("userEmail"));
		          dt.setUserCountry(request.getParameter("userCountry"));
		    
			         ServiceClasss  sr=new ServiceClasss();
		             int flag= sr.validity(dt);
		             if(flag==1)
		            	 {
		            	
		            	 DaoClass dao=new DaoClass();
		            	   int n= dao.insertData(dt);
		            	    if(n>=1)
		            	    {   out.print("<h1>successfull Register");
		            	    RequestDispatcher rd=request.getRequestDispatcher("/View.html");
		            	    rd.include(request, response);  
		            	    
		            	    
		            	    String to=request.getParameter("userEmail");//change accordingly  
		            	      
		            	      //Get the session object  
		            	      Properties props = new Properties();  
		            	      props.put("mail.smtp.host", "smtp.gmail.com");  
		            	      props.put("mail.smtp.socketFactory.port", "465");  
		            	      props.put("mail.smtp.socketFactory.class",  
		            	                "javax.net.ssl.SSLSocketFactory");  
		            	      props.put("mail.smtp.auth", "true");  
		            	      props.put("mail.smtp.port", "465");  
		            	       
		            	      Session session = Session.getDefaultInstance(props,  
		            	       new javax.mail.Authenticator() {  
		            	       protected PasswordAuthentication getPasswordAuthentication() {  
		            	       return new PasswordAuthentication("bangarneeraj95@gmail.com","8349967437");//change accordingly  
		            	       }  
		            	      });  
		            	       
		            	      //compose message  
		            	      try {  
		            	       MimeMessage message = new MimeMessage(session);  
		            	       message.setFrom(new InternetAddress("bangarneeraj95@gmail.com"));//change accordingly  
		            	       message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		            	       message.setSubject(request.getParameter("userName"));  
		            	       message.setText("welcome user you successfull Register ");  
		            	         
		            	       //send message  
		            	       Transport.send(message);  
		            	      
		            	       System.out.println("message sent successfully");  
		            	       
		            	      } catch (MessagingException ex) {throw new RuntimeException(ex);} 
		            	           
		            	         
		              
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	    
		            	 }}
		             else{out.print("try again");
		             out.print(request.getParameter("useName"));  out.print(request.getParameter("userPass")); 
		             out.print(request.getParameter("userEmail")); out.print(request.getParameter("userCountry"));}
		         
		         
		         
	
	}

}
