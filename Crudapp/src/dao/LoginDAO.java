package dao;

import java.sql.*;

import connectionmanagement.connectionmanager;
import model.Login;

public class LoginDAO {
	public boolean checkCredential(Login l) throws ClassNotFoundException, SQLException 
	{
		//1. get the details from Login.java file
		String username = l.getUsername();
		String password = l.getPassword();
		
		//2. jdbc connection
		connectionmanager cm= new connectionmanager();
		Connection con = cm.establishConnection();
		
		//3. create the statement
		Statement st = con.createStatement();
		 
		//4. write and execute the query
		ResultSet rt = st.executeQuery("select * from login");
		
		//5. check username and password
		while(rt.next())
		{
			if(username.equals(rt.getString("username")) && (password.equals(rt.getString("password"))))
			{
				cm.closeConnection();
				return true;
			}
		}
		cm.closeConnection();
		   return false;
		
		
		}

}
