package connectionmanagement;

import java.sql.*;

public class connectionmanager {
	Connection cn = null;
	public Connection establishConnection()throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb","root","koppadisowmya");
		return cn;
	}
	public void closeConnection() throws  SQLException
	{
		cn.close();
	}
	
        
}
