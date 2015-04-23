<%@ page import="java.sql.*"%>  
  
<%  
String s=request.getParameter("val");  
String str="";
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
 str+=rs.getString(1)+",";
   str+=rs.getString(2)+",";
   str+=rs.getString(3)+",";
   str+=rs.getString(4)+",";
}  
 out.print(str);  
con.close();  
}catch(Exception e){e.printStackTrace();}  

%>  