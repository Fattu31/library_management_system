package library_management_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class UserCurd {
	public void signUp(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception 
	{
		Connection connection=getConnection( );
		String qurey="INSERT INTO library(ID,NAME,PHONE,EMAIL,PASSWORD) VALUES(?,?,?,?,?)";
		PreparedStatement preparedStatement=connection.prepareStatement(qurey);
		preparedStatement.setInt(1, user.getId());
		preparedStatement.setString(2, user.getName());
		preparedStatement.setLong(3, user.getPhone());
		preparedStatement.setString(4, user.getEmail());
		preparedStatement.setString(5, user.getPassword());
		int result = preparedStatement.executeUpdate();
		if(result!=0)
		{
			System.out.println("Signup Successfully");
		Welcome_Page.controller(user,curd,book1,bookCurd12,scanner);
		}
		
		else{
			System.out.println("Signup Failed");
		}
		connection.close();
	}
	public void login(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception
	{
			Connection connection=getConnection( );
			String qurey1="SELECT * FROM LIBRARY WHERE EMAIL=?";
			PreparedStatement preparedStatement=connection.prepareStatement(qurey1);
			preparedStatement.setString(1, user.getEmail());
			ResultSet resultSet=preparedStatement.executeQuery();
		    if(resultSet.next())
		    {
		    	if(user.getPassword().equals(resultSet.getString("password")))
		    	{
		    		System.out.println("Login Successfully");
		    		BookSwitch.book(user,curd,book1,bookCurd12,scanner);
		    		
		    		}
		       else
		       {
		    	System.out.println("Invalid Password");	
		    	
		       }

		    }
		    else
		    {
		    	System.out.println("User not register");
		    }
		    
	}
	
	public Connection getConnection() throws Exception
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

}
