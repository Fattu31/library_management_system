package library_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class BookCurd {
	
		public Connection getConnection1() throws Exception
		{
			String classname="com.mysql.cj.jdbc.Driver";
		 	   String url="jdbc:mysql://localhost:3306/librarydb";
		 	   String user="root";
		 	   String pass="root";
			//1. Load or Register driver
		    Class.forName(classname);
		    //2. Establish connection 
		   Connection connection= DriverManager.getConnection(url, user, pass);
		   return connection;
	}
		public void addBook(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception {
			Connection connection=getConnection1( );
//			Book book3=new Book();
			String qurey="INSERT INTO book(ID,NAME,author,price,genre) VALUES(?,?,?,?,?)";
			PreparedStatement preparedStatement=connection.prepareStatement(qurey);
			preparedStatement.setInt(1, book1.getId());
			preparedStatement.setString(2, book1.getName());
			preparedStatement.setString(3, book1.getAuthor());
			preparedStatement.setDouble(4, book1.getPrice());
			preparedStatement.setString(5, book1.getGenre());
	        int result = preparedStatement.executeUpdate();
	        if(result!=0)
			{
				System.out.println("Book Added");
				BookSwitch.book(user, curd, book1, bookCurd12, scanner);
			}
			
			else{
				System.out.println("Book Not Added");
			}
			connection.close();
		}
		public void deleteBook(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception {
			Connection connection=getConnection1( );
			 String qurey="DELETE FROM book where name=?";
			 System.out.println("Enter your Name");
	 			String name =scanner.next();
			 PreparedStatement preparedStatement=connection.prepareStatement(qurey);
			   preparedStatement.setString(1, name);
			   int result= preparedStatement.executeUpdate();
			   if(result!=0)
			   {
				   System.out.println("Deleted");
				   BookSwitch.book(user, curd, book1, bookCurd12, scanner);
				   
			   }
			   else {
				   System.out.println("Not Deleted");
			   }
			   connection.close();
			   }
		public void updateBook(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception{
			Connection connection=getConnection1( );
			System.out.println("Enter your Name");
			String name =scanner.next();
			
			System.out.println("Enter your Author");
		     String  author =scanner.next();
			
			System.out.println("Enter your Price");
			Double price =scanner.nextDouble();
			
			System.out.println("Enter your Genre");
			String genre =scanner.next();
			
			System.out.println("Enter your id");
			int id =scanner.nextInt();
	 	    
	 	    String qurey="Update book set name=?,author=?,price=?,genre=? where id=?";
	 	    PreparedStatement preparedStatement=connection.prepareStatement(qurey);
	 	       preparedStatement.setString(1, name);
			   preparedStatement.setString(2, author);
			   preparedStatement.setDouble(3,price );
			   preparedStatement.setString(4, genre );
			   preparedStatement.setInt(5,id );
			  
			   int result= preparedStatement.executeUpdate();
			   if(result!=0)
			   {
				   System.out.println("Updated");
				   BookSwitch.book(user, curd, book1, bookCurd12, scanner);
			   }
			   else {
				   System.out.println("Not Updated");
			   }
			   connection.close();
		}
		public void getById(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception {
			Connection connection=getConnection1( );
//			System.out.println("Enter your id");
//			int id =scanner.nextInt();
//			
//			System.out.println("Enter your Name");
//			String name =scanner.next();
//			
//			String qurey = "SELECT id FROM books WHERE name= ?";
//			 PreparedStatement preparedStatement=connection.prepareStatement(qurey);
//			 preparedStatement.setInt(1, id);
//			 preparedStatement.setString(2, name);
//			 ResultSet resultSet = preparedStatement.executeQuery();
//			 while(resultSet)
//  	       {
//  	    	   System.out.print(resultSet.getInt("id")+" ");
//  	       }
		}
		}
		
		

