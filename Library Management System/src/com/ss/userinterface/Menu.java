package com.ss.userinterface;
import com.ss.lib.service.Service;
import com.ss.lib.dao.*;
import com.ss.entities.*;
import java.util.Scanner;

public class Menu {
	
	//import value entered by user
			static Scanner userInput = new Scanner(System.in); 
			
			// loop will execute all the time unless they selected exit
			static boolean stop= true;
			
			// value entered by user will be stored in choice
			static  String choice= "";
			 
	public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } 
        catch(Exception E) {
            System.out.println(E);
        }
    }
	
	
	public static void editAuthor() {
		System.out.println ("What would you like to do today?");
		System.out.println ("(1) Create new author record");
		System.out.println ("(2) Update author information");
		System.out.println ("(3) Delete author");
		System.out.println ("(4) View author");
		System.out.print ("Please enter your choice here (number): ");
		choice = userInput.nextLine();
		
		switch(choice) {
		case "1":
			System.out.println("Enter the author ID: ");
			String authorId = userInput.nextLine();
			
			System.out.println("Enter the author Name: ");
			String authorName = userInput.nextLine();
			
			Service.createAuthor(authorId, authorName);
			break;
		case "2":
			System.out.println("Enter the author ID: ");
			 authorId = userInput.nextLine();
			
			System.out.println("Enter the author Name: ");
			authorName = userInput.nextLine();
			
			Service.updateAuthor(authorId, authorName);
			break;
		case "3":
			System.out.println("Enter the author ID: ");
			 authorId = userInput.nextLine();
			
			Service.deleteAuthor(authorId);
			break;
		case "4":
			for(Author newAuthorList : AuthorDAO.readAuthor()) {
                System.out.println(newAuthorList.getAuthorId() + "\t" + newAuthorList.getAuthorName());
            }
			System.out.print("Press any key to continue...");
            choice = userInput.nextLine();
			break;
		default:
			System.out.println ("Invalid choice; please try again");
			break;	
		}
		
	}
		public static void editPublisher() {
			System.out.println ("What would you like to do today?");
			System.out.println ("(1) Create new publisher record");
			System.out.println ("(2) Update publisher information");
			System.out.println ("(3) Delete publisher");
			System.out.println ("(4) View publisher");
			System.out.print ("Please enter your choice here (number): ");
			choice = userInput.nextLine();
			
			switch(choice) {
			case "1":
			
				System.out.println("Enter the publisher ID: ");
				String publisherId = userInput.nextLine();
				
				System.out.println("Enter the publisher Name: ");
				String publisherName = userInput.nextLine();
				
				System.out.println("Enter the publisher Address: ");
				String publisherAddress = userInput.nextLine();
				
				
				Service.createPublisher(publisherId, publisherName, publisherAddress);
				break;
			case "2":
				System.out.println("Enter the publisher ID: ");
				 publisherId = userInput.nextLine();
				
				System.out.println("Enter the publisher Name or N/A for no change: ");
				 publisherName = userInput.nextLine();
				
				System.out.println("Enter the publisher Address or N/A for no change: ");
				 publisherAddress = userInput.nextLine();
				
				
				Service.updatePublisher(publisherId, publisherName, publisherAddress);
				break;
			case "3":
				System.out.println("Enter the publisher ID: ");
				 publisherId = userInput.nextLine();
				 
				Service.deletePublisher(publisherId);
				break;
			case "4":
				for(Publisher newPublisherList : PublisherDAO.readPublisher()) {
	                System.out.println(newPublisherList.getPublisherId() + "\t" + newPublisherList.getPublisherName());
	            }
				System.out.print("Press any key to continue...");
	            choice = userInput.nextLine();
				break;
			default:
				System.out.println ("Invalid choice; please try again");
				break;	
			}
		}	
			
			public static void editBook() {
				System.out.println ("What would you like to do today?");
				System.out.println ("(1) Create new book record");
				System.out.println ("(2) Update book information");
				System.out.println ("(3) Delete book");
				System.out.println ("(4) View book");
				System.out.print ("Please enter your choice here (number): ");
				choice = userInput.nextLine();
				
				switch(choice) {
				case "1":
					System.out.println("Enter the book ID: ");
					String bookId = userInput.nextLine();
					
					System.out.println("Enter the book Name: ");
					String bookName = userInput.nextLine();
					
					System.out.println("Enter the author ID: ");
					String authorId = userInput.nextLine();
					
					System.out.println("Enter the publisher ID: ");
					String publisherId = userInput.nextLine();
					
					Service.createBook(bookId, bookName, authorId, publisherId);
					break;
				case "2":
					System.out.println("Enter the book ID: ");
					 bookId = userInput.nextLine();
					
					System.out.println("Enter the book Name: ");
					 bookName = userInput.nextLine();
					 
					Service.updateBook(bookId, bookName);
					break;
					
					
				case "3":
					System.out.println("Enter the book ID: ");
					 bookId = userInput.nextLine();
			
					Service.deleteBook(bookId);
					break;
					
				case "4":
					for(Book newBookList : BookDAO.readBook()) {
		                System.out.println(newBookList.getBookId() + "\t" + newBookList.getBookName()+ "\t" + newBookList.getAuthorId()+ "\t" + newBookList.getPublisherId());
		            }
					System.out.print("Press any key to continue...");
		            choice = userInput.nextLine();
					break;
					
				default:
					System.out.println ("Invalid choice; please try again");
					break;	
				}	
			}	
		
	public static void main(String[] args) {
		
		while (choice  != "4") {

			System.out.println ();
			System.out.println ("**************************************");
			System.out.println ("*Welcome to Library Management System*");
			System.out.println ("**************************************");
			System.out.println ();
			
			System.out.println ("What would you like to work with today?");
			System.out.println ("(1) Author");
			System.out.println ("(2) Book");
			System.out.println ("(3) Publisher");
			System.out.println ("(4) Exit menu");
			System.out.println("Please enter your choice here (number): ");
			
			choice = userInput.nextLine();
			
			switch(choice) {
			case "1":
				editAuthor();
				
				break; 
				
			case "2":
				editBook();
				
				break;
			
			case "3":
				editPublisher();
				break;
			case "4":
				clearScreen();
				System.out.println ("Good day!");
				 stop = false;
				break;
				
			default:
				
				System.out.println ("Invalid choice; please try again");
				
				break;	
				
				
			}
			
		} 
    }

}
			
