package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.DtoClass;

public class DaoClass {
static	Connection con1;static	Connection con;
	
		public ArrayList<DtoClass> dispalyData()	{
	        	 ResultSet rs;
	        	    ArrayList<DtoClass> arraylistobj=new  ArrayList<DtoClass>();
				try{
					Class.forName("oracle.jdbc.driver.OracleDriver");  
					con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
					System.out.println("con");
					   java.sql.Statement stmt = con.createStatement();
			             
			              rs = stmt.executeQuery("select * from Registeruser");
			          
			              while (rs.next()) {
			            	   DtoClass dto=new DtoClass();
				                 dto.setUserName( rs.getString(1));
				                dto.setUserPassword( rs.getString(2));
				                dto.setUserEmail( rs.getString(3));
				                dto.setUserCountry( rs.getString(4));
				                arraylistobj.add(dto);
			              }
			            
				}catch (Exception e) {System.out.println(e);
				}
				
				
			return arraylistobj; 
		}
		
		
		
		
	
	public  int insertData(DtoClass dt) 
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		PreparedStatement ps=con.prepareStatement("insert into registeruser values(?,?,?,?)");  
		 
		ps.setString(1,dt.getUserName());  
		ps.setString(2,dt.getUserPassword());  
		ps.setString(3,dt.getUserEmail());  
		ps.setString(4,dt.getUserCountry());  
		          
		int i=ps.executeUpdate();  System.out.println(i);
		return i;
		}
		catch (Exception e) {
		System.out.println(e);
		}
		return 0;
	}
	
	public int updateData(DtoClass dt)	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			con=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
//	PreparedStatement ps=con.prepareStatement("update  registeruser  SET NAME='navin', PASS='123',Email='A@',COUNTRY='ind' WHERE NAME='neeraj' ");  
		  java.sql.Statement stmt = con.createStatement();
		String query=" update  registeruser  SET NAME='"+dt.getUserName()+"',PASS='"+dt.getUserPassword()+"',EMAIL='"+dt.getUserEmail()+"',COUNTRY='"+dt.getUserCountry()+"'  where NAME='"+dt.getUserName()+"' ";
		
		  int i= stmt.executeUpdate(query);
		  stmt.execute("commit");
		System.out.println("connection 8");

		/* 
		ps.setString(1,dt.getUserName());  
		ps.setString(2,dt.getUserPassword());  
		ps.setString(3,dt.getUserEmail());  
		ps.setString(4,dt.getUserCountry());  
		ps.setString(5,dt.getUserName());  
		*/
		          
	//	int i=ps.executeUpdate();
		System.out.println(i);
		return i;
		}
		catch (Exception e) {System.out.println(e);}
		return 0;
}
	public ArrayList<DtoClass> 	editData(String sql)	{
      	 ResultSet rs;
      	    ArrayList<DtoClass> arraylistobj=new  ArrayList<DtoClass>();
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");  
				con1=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				System.out.println("connection for edit"+sql);
				System.out.println(con1);
				   java.sql.Statement stmt = con1.createStatement();
				   //'"+sql+"'"
		              rs = stmt.executeQuery("select * from Registeruser where NAME='"+sql+"'");
		              System.out.println("after run query");
		        //    System.out.println(stmt.execute("select * from Registeruser where NAME='"+sql+"'"));
		             
		          //    System.out.println(rs.next());
		              while (rs.next()) {
		            	  System.out.println(rs.getString(1));
		            	   DtoClass dto=new DtoClass();
			                 dto.setUserName( rs.getString(1));
			                dto.setUserPassword( rs.getString(2));
			                dto.setUserEmail( rs.getString(3));
			                dto.setUserCountry( rs.getString(4));
			                arraylistobj.add(dto);
		              }
		            
			}catch (Exception e) {System.out.println(e);
			}
				return arraylistobj; 
	}





	public boolean  LoginData(DtoClass dto) {
		// TODO Auto-generated method stub
		 boolean flag =false;
		try{
		//Class.forName("oracle.jdbc.driver.OracleDriver");  
		con1=DriverManager.getConnection( "jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		System.out.println("connection for login"+dto.getUserName());
		System.out.println(con1);
		   java.sql.Statement stmt = con1.createStatement();
		
             flag = stmt.execute("select * from Registeruser where NAME='"+dto.getUserName()+"' and PASS='"+dto.getUserPassword()+"'");
              System.out.println("after run query");
        //    System.out.println(stmt.execute("select * from Registeruser where NAME='"+sql+"'"));
		}catch(Exception e){System.out.println(e);}
		
		return flag;
		
	}





	
	}
