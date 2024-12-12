package rmi;
import java.rmi.*;

import java.sql.*;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;




@SuppressWarnings("serial")
public class formimpl extends UnicastRemoteObject implements form {
	private Connection con;

	public formimpl()throws RemoteException{
	String url="jdbc:mysql://localhost:3306/form1";
	String userName = "root";
	String password = "9342864391";
	try {
	 con = DriverManager.getConnection(url,userName,password);
	
	 
	
	}catch(SQLException e)
	{
        e.printStackTrace();
        throw new RemoteException("Database connection error", e);
    }
	
	}



	public String stdData(int eno, String name, String dept, String desg, String uname, String prd)
			throws RemoteException {
		
			String insertQuery = "INSERT INTO form1 (eno, na, dp, dg, un, pd) VALUES (?, ?, ?, ?, ?, ?)";
			 try (PreparedStatement pstmt = con.prepareStatement(insertQuery)) {
		            pstmt.setInt(1, eno);
		            pstmt.setString(2, name);
		            pstmt.setString(3, dept);
		            pstmt.setString(4, desg);
		            pstmt.setString(5, uname);
		            pstmt.setString(6, prd);
		            int rowsAffected = pstmt.executeUpdate();
		            return rowsAffected > 0 ? "Student form inserted" : "Student form not inserted";
		        } catch (SQLException e) {
		            e.printStackTrace();
		            return "Error inserting student form: " + e.getMessage();
		        }
		    }
}
		

