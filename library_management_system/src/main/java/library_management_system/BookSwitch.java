           package library_management_system;

import java.util.Scanner;

public class BookSwitch {
	public static void book(User user,UserCurd curd,Book book1, BookCurd bookCurd12,Scanner scanner) throws Exception {

		 System.out.println("1. Get all books");
	     System.out.println("2. Add book");
	     System.out.println("3. Delete book");
	     System.out.println("4. Update book details");
	     System.out.println("5. Get book by ID");
	     System.out.println("6. Get book by name");
	     System.out.println("7. Get book by author");
	     System.out.println("8. Get book by price");
	     System.out.println("9. Get book by genre");
	     System.out.println("10. Logout");
			
    	switch(scanner.nextInt())
 		{
 		case 1 : {
 			         System.out.println("A Tale Of Two Cities");
 			         System.out.println("Ikigai");
 			         System.out.println("Harry Potter");
 			         System.out.println("The Little Prince");
 			         System.out.println("Inner Engineerging");
 			         System.out.println("And Then There Were None");
 			        BookSwitch.book(user, curd, book1, bookCurd12, scanner);
 		}
 		break;
 		case 2 : {
 			System.out.println("Enter your id");
			int id =scanner.nextInt();
			
			System.out.println("Enter your Name");
			String name =scanner.next();
			
			System.out.println("Enter your Author");
		     String  author =scanner.next();
			
			System.out.println("Enter your Price");
			Double price =scanner.nextDouble();
			
			System.out.println("Enter your Genre");
			String genre =scanner.next();
			book1.setId(id);
			book1.setName(name);
			book1.setAuthor(author);
			book1.setPrice(price);
			book1.setGenre(genre);
			bookCurd12.addBook(user,curd,book1,bookCurd12,scanner);
 			
 		   }
 		break;
 		case 3 :{
			bookCurd12.deleteBook(user,curd,book1,bookCurd12,scanner);
 		}
 		break;
 		case 4 : {
			bookCurd12.updateBook(user,curd,book1,bookCurd12,scanner);
 		}
 		break;
 		case 5:{
			bookCurd12.getById(user,curd,book1,bookCurd12,scanner);
 		}
 		break;
 		case 6: {
 			
 		}
 		break;
        case 7: {
 			
 		}
 		break;
        case 8: {
		
	    }
	    break;
        case 9: {
		
	     }
       	break;
         default : {
		    System.out.println("logout");
	     }
        break;
	   
    }
    }
}

