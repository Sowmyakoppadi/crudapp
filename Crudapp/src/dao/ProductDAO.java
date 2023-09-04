package dao;

import java.sql.*;

import connectionmanagement.connectionmanager;
import model.product;

public class ProductDAO {
	public void  addproduct(product p) throws ClassNotFoundException, SQLException
	{
		connectionmanager cm = new connectionmanager();
		Connection con = cm.establishConnection();
		String que = "insert into product(ProdId,ProdName,Product_quantity,Product_minsell,Product_price) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(que);
		ps.setInt(1, p.getProdId());
		ps.setString(2, p.getProdName());
		ps.setInt(3,p.getProduct_quantity());
		ps.setInt(4, p.getProduct_minsell());
		ps.setInt(5, p.getProduct_price());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void display(product p) throws SQLException, ClassNotFoundException
	{
		//2.jdbc connection
		connectionmanager cm=new connectionmanager();
		Connection con=cm.establishConnection();
		
		//3.where to write queries
		//3.1 create statement class
		Statement st=con.createStatement();
		
		//3.2 Write execute the queries
		ResultSet rt = st.executeQuery("select * from product");
		
		//4. print
		while(rt.next())
		{
			System.out.println(rt.getInt("ProdId")+"  "+rt.getString("ProdName")+"  "+rt.getInt("Product_quantity")+"  "+rt.getInt("Product_minsell")+"   "+rt.getInt("Product_price")+"  ");
		}
		cm.closeConnection();	
	}
	public void update(product p) throws ClassNotFoundException, SQLException
	{
		connectionmanager cm=new connectionmanager();
		Connection con=cm.establishConnection();
		String que = "update product set ProdName=?,Product_quantity=?,Product_minsell=?,Product_price=? where ProdId=?";
		PreparedStatement ps = con.prepareStatement(que);
		ps.setInt(1, p.getProdId());
		ps.setString(2, p.getProdName());
		ps.setInt(3,p.getProduct_quantity());
		ps.setInt(4, p.getProduct_minsell());
		ps.setInt(5, p.getProduct_price());
		ps.executeUpdate();
		cm.closeConnection();
	}
	public void delete(product p) throws ClassNotFoundException, SQLException
	{
		connectionmanager cm=new connectionmanager();
		Connection con=cm.establishConnection();
		String que ="delete  from product where ProdId=?";
		PreparedStatement ps = con.prepareStatement(que);
		ps.setInt(1, p.getProdId());
		ps.executeUpdate();
		cm.closeConnection();
	}
}