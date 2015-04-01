<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="dto.DtoClass" %>
     <%@ page import="Dao.DaoClass" %>
     <%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% try{   DaoClass dao=new DaoClass();
	        	     ArrayList<DtoClass> al= dao.dispalyData();
	        	                         Iterator<DtoClass> it=al.iterator(); out.println("while start");%>
	        	                         <table border=1 width=50% height=50%>
	        	                         <tr><th>UserName</th><th>UserPassword</th><th>EmailId</th><th>userCountry</th><th>Edit</th><tr>
	        	                       
	        	                         <%    while (it.hasNext())
	                                   {
	                                      DtoClass n=it.next() ; 
	                                      
	                                      %>
	                                   
<tr><td><%= n.getUserName() %></td><td> <%=n.getUserPassword() %></td><td><%=n.getUserEmail()  %></td><td><%=n.getUserCountry()  %></td> 

<% String s1=n.getUserName(); %>
<td> <div> <a href='http://localhost:7070/Demo/EditData?uname="<%=n.getUserName()%>"'>Edit</a> </div> </td></tr>
  
	    <%   }   }   catch (Exception e) {
	             out.println(e);
	         }  %>
	         </table>
</body>
</html>