<%@ page import="java.sql.*"%>  
  
<%  
String s=request.getParameter("val");  

out.print(s);  
try{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
PreparedStatement ps=con.prepareStatement("select * from Registeruser where NAME=?");  
ps.setString(1,s);  
ResultSet rs=ps.executeQuery();  
//ps.executeQuery("commit");
out.println("welcome");
while(rs.next()){  
out.print(rs.getString(1)+"  <html><body>   <h1> "+rs.getString(2));  
}  
con.close();  
}catch(Exception e){e.printStackTrace();}  

%>  