package controller;
import java.sql.SQLException;
import java.util.Scanner;

import dao.LoginDAO;
import dao.ProductDAO;
import model.Login;
import model.product;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc=new Scanner(System.in);
		int choice,option;
		Login l=new Login();
		LoginDAO ld=new LoginDAO();
		product p=new product();
		ProductDAO pdao=new ProductDAO();
		do {
			System.out.print("1. Admin\n2. Agent\n3. Exit\n**************************************************************\nEnter your choice: ");
			choice=sc.nextInt();

			switch(choice)
			{
			case 1: System.out.println("Admin Login");
					System.out.println("UserName:");
					String username=sc.next();
				    System.out.println("password:");
					String password=sc.next();
					l.setUsername(username);
					l.setPassword(password);
					if(ld.checkCredential(l))
					{	System.out.println("Login Successfull\n\n");
					do {
					System.out.println("1. Add product\n2. Display Product\n3. Update Product\n4. Delete a product\n5. Logout\n*********************************************************\nEnter your choice: ");
					option=sc.nextInt();
					switch(option)
					{
					case 1: 
							System.out.println("Enter Product Id: ");
							int id=sc.nextInt();
							System.out.println("Enter Product name: ");
							String product=sc.next();
							System.out.println("Enter Product minimum sell quality: ");
							int minsellq=sc.nextInt();
							System.out.println("Enter Product price: ");
							int Price=sc.nextInt();
							System.out.println("Enter Product quantity: ");
							int quatity=sc.nextInt();
							p.setProdName(product);
							p.setProdId(id);
							p.setProduct_minsell(minsellq);
							p.setProduct_price(Price);
							p.setProduct_quantity(quatity);
							pdao.addproduct(p);
							System.out.println("Product added successfully\n");
							break;
					case 2: System.out.println("These are the products:\n");
							pdao.display(p);
							break;
					case 3: 
						System.out.println("Update a Product\n");
					System.out.println("Enter Product Id to update: ");
					int id1=sc.nextInt();
					System.out.println("Enter Product name: ");
					String product1=sc.next();
					System.out.println("Enter Product minimum sell quality: ");
					int minsellq1=sc.nextInt();
					System.out.println("Enter Product price: ");
					int Price1=sc.nextInt();
					System.out.println("Enter Product quantity: ");
					int quatity1=sc.nextInt();
					p.setProdId(id1);
					p.setProdName(product1);
					p.setProduct_minsell(minsellq1);
					p.setProduct_price(Price1);
					p.setProduct_quantity(quatity1);
					pdao.update(p);
			    	System.out.println("Product updated successfully\n");
			    	break;
				case 4:
					System.out.println("Delete a Product\nEnter Product_ID to delete:");	
			        	int id2=sc.nextInt();
			        	p.setProdId(id2);
			        	pdao.delete(p);
			        	System.out.println("Deleted Successfully\n");
				case 5: break;
				}
			}while(option!=5);
					}
					else
						System.out.println("\nInvalid username/password");
					
					break;
			case 2: System.out.println("Agent Login");
					System.out.println("User Name");
					String usrname=sc.next();
					System.out.println("Passwrd");
					String passwrd=sc.next();
					l.setUsername(usrname);
					l.setPassword(passwrd);
					if(ld.checkCredential(l))
					{
						int ch;
					do {
						System.out.println("1. Display Product\n2.Logout\n");
						 ch=sc.nextInt();
						switch(ch)
						{
						case 1: System.out.println("These are the products: \n");
						pdao.display(p);
								break;
						case 2: break;
						}
					}while(ch!=2);
					}
					else
						System.out.println("Invalid username/Password");
					break;
			case 3:System.exit(0);
			}
		}while(choice!=3);
		sc.close();
	}
}