<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*;" %>
<html>
<head>
<script type="text/javascript" src="jquery-1.10.2.min.js"></script>
<script>  

function validateform(){ 

var name=document.myform.name.value;  
var password=document.myform.pass.value;  
 var x=document.myform.email.value;  
var a=x.indexOf("@");  
var d=x.lastIndexOf(".");   
if (name==null || name==""){  
  alert("username can't be blank"); 
   return false;  
}else  if(password.length<6){  
  alert("Password must be at least 6 characters long.");  
  return false;  
     }
  
else if (a<1 || d<a+2 || d+3>=x.length){  
  alert("Please enter a valid e-mail address");  
  return false;  
  }  
  
  else  if(name==null || name==""){  
  alert("Password must be at least 6 characters long.");  
  return false;  
     }  
}  
</script>  

<style type="text/css">

.from1{
background-color: #52854C;
font-family: Georgia;color: white;padding: 25px;width: 500px;border: 2px black solid;-moz-border-radius: 15px;-webkit-border-radius: 15px;
-khtml-border-radius:15px;border-radius: 15px;-webkit-box-shadow:inset 1px 1px 2px #999;-moz-box-shadow:inset 1px 1px 2px #999;
-khtml-box-shadow:inset 1px 1px 2px #999;box-shadow:inset 1px 1px 2px #999;}

.error{ 
      color:red; margin-:100; position:relative;}
.white{ 
    border:2px solid blue;
  color:#FFFFFF; background-color:#999999}

.red{ 
    border:2px solid blue;
  color:#006633; }
  .ss{
  margin-left:80%;
  }
 </style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><div class="from1">
<table>
  <form name="myform" method="post" action="Register" onSubmit="return validateform()" >
    <tr>        
        <td colspan=5 ><font size=3><center><b><p>REGSTRATION FORM</p></b></center>        
    </br>	</tr>
   
    <tr>
      <td width="220">First Name:<br/></td>
      <td width="164"><input name="name" type="text" id="name" size="25" ><span class="n"></span>
      <br/></td>
    </tr>
    
    <tr>
      <td width="220">Last Name:<br/></td>
      <td width="164"><input name="LastName" type="text" id="lname" size="25"><span class="n"></span>
      <br/></td>
    </tr>
	 <tr>
      <td width="220" height="31">UserName:<br/></td>
      <td width="164"><input name="user" type="text" id="user" size="25" placeholder="eg:neeraj" />
       <span class="u"></span></td>
    </tr>
	
    <tr>
      <td width="220">passward:<br/></td>
      <td width="164"><input name="pass" type="password" id="pass" placeholder="***********" size="25" />
      <span class="p"></span> <br/>      </td>
    </tr>
    <tr>
      <td width="220">Email :<br/></td>
      <td width="164">
        <input name="email" type="text" id="email" size="25"  placeholder="eg:neerajbangar94@gmail.com"><span class="e"></span>
      <br/></td></tr>
	  
	
	  
	  
	  
	  
	  
	   <td width="209">JobCategory :<br/></td>
      <td width="471">
	<%  try{  
	Class.forName("oracle.jdbc.driver.OracleDriver");  
Connection con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
PreparedStatement ps=con.prepareStatement("select * from Registeruser ");  
  
ResultSet rs=ps.executeQuery();  
 %>
  

	  <select name="Role" style="width:98%;" >
 <option>Select</option>
<% try{
	
	while(rs.next())
	out.print("<option value="+rs.getString(1)+">"+rs.getString(1)+"</option>");
	}catch(Exception e1){out.print(e1);}
	}catch(Exception e){e.printStackTrace();}  
%>
 </select>
	  
      <span class="cj"></span>
      <br/></td></tr>
	  
	   
	 
	 
	  
    <tr>
      <td height="71" margin-left:120px><center><input class="ss" type="submit" id="b1"  name="submit" value="register"></center>    </tr>
	 <tr> <td  width="10000"><p><em>By clicking Register, I agree to neerzaj.com's <a href="../../../web1/Terms.aspx">Terms and Conditions</a></em>
	   </p></td></tr>
  </form>
</table>
</div>
</body>
</html>