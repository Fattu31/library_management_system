package library_management_system;

import java.util.*;
public class Welcome_Page {
    public static void main(String[] args) throws Exception {
    	
    	Scanner scanner=new Scanner(System.in);
		User user=new User( );
		UserCurd curd=new UserCurd( );
		 Book book1=new Book();
		 BookCurd bookCurd12=new BookCurd();
		 controller(user,curd,book1,bookCurd12,scanner);
		 
    }
		
	   
	    public static void controller(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception
	    {
		 System.out.println("******!!WELCOME ADMIN!!******");
			System.out.println(" 1. SignUp \n 2. Login \n    Any number for Exit ");
		switch(scanner.nextInt())
		{
		case 1 : {
			System.out.println("Enter your id");
			int id =scanner.nextInt();
			
			System.out.println("Enter your Name");
			String name =scanner.next();
			
			System.out.println("Enter your phone");
			long phone =scanner.nextLong();
			
			System.out.println("Enter your email");
			String email =scanner.next();
			
			System.out.println("Enter your password");
			String password =scanner.next();
			user.setId(id);
			user.setName(name);
			user.setPhone(phone);
			user.setEmail(email);
			user.setPassword(password);
			curd.signUp(user,curd,book1,bookCurd12,scanner);
			
		   }
		break;
		
		case 2 :
		{
			System.out.println("Enter your email");
			String email =scanner.next();
			
			System.out.println("Enter your password");
			String password =scanner.next();
			user.setEmail(email);
			user.setPassword(password);
			curd.login(user,curd,book1,bookCurd12,scanner);
			
	 		
		}
		break;
		default :
		{
			System.out.println("You are Exit");
		}
		break;
		        
		}
	}
}
