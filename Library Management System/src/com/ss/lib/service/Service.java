package com.ss.lib.service;

import java.util.Iterator;
import java.util.List;

import com.ss.entities.*;
import com.ss.lib.dao.*;

public class Service {
	
	public static void createAuthor(String aId, String aName) {
		
		//newAuthorList is a new list and it's type will be same as <Author>
		//readAuthor has returned list at the end 
		
		List<Author> newAuthorList = AuthorDAO.readAuthor();
		
		//int i=0; i<newAuList.length, i++;  
		for(Author i: newAuthorList) { //i: id =1 and name: sayana both like foreach
			//check if id already exists
			if (i.getAuthorId().equals(aId)) {
				System.out.println("This id author already exists.");
				return;
			}
		}
		
		//if does not exists
		Author newAuthor = new Author(aId, aName);
		newAuthorList.add(newAuthor);
		AuthorDAO.writeAuthor(newAuthorList);	
	}
		
	public static void createPublisher(String pId, String pName, String pAddress) {
			List<Publisher> newPublisherList = PublisherDAO.readPublisher();
			
			  
			for(Publisher j: newPublisherList) { 
				if (j.getPublisherId().equals(pId)) {
					System.out.println("This id publisher already exists.");
					return;
				}
			}
			
			Publisher newPublisher = new Publisher(pId, pName, pAddress);
			newPublisherList.add(newPublisher);
			PublisherDAO.writePublisher(newPublisherList);	
		}
	
		public static void createBook(String bId, String bName, String aId, String pId) {
			
			List<Publisher> newPublisherList = PublisherDAO.readPublisher();
			List<Author> newAuthorList = AuthorDAO.readAuthor();
			List<Book> newBookList = BookDAO.readBook();
			//Scanner userInput = new Scanner(System.in); 
			
			for(Book k: newBookList) { 
				if (k.getBookId().equals(bId)) {
					System.out.println("This id book already exists.");
					return;
				}
			}
			
			boolean exists = false; //exists in author and publisher
			
			for(Author i: newAuthorList) { //i: id =1 and name: sayana both like foreach
				//check if id already exists
				if (i.getAuthorId().equals(aId)) {
					exists = true;
					break;
				}
			}
			if (exists == true) {
				for(Publisher j: newPublisherList) { 
					if (j.getPublisherId().equals(pId)) {
						exists = true;
						break;
					}
					if (exists == false) {
						
			            return;
					}
				}
			}
			else {
				
	        return;
			}
			
			Book newBook = new Book(bId, bName, aId, pId);
			newBookList.add(newBook);
			BookDAO.writeBook(newBookList);
		}
		
		public static void updateAuthor(String aId, String aName) {
			List<Author> newAuthorList = AuthorDAO.readAuthor();
			
			        int location = 0;
			        
			        //check if author ID exists
			        for(Author checkId : newAuthorList) {
			            if(checkId.getAuthorId().equals(aId)) {
			            	location = newAuthorList.indexOf(checkId);// get index of the record to be updated
			            	newAuthorList.get(location).setAuthorName(aName); 
			                AuthorDAO.writeAuthor(newAuthorList); 
			                return;
			            }
			        }
			        
			        System.out.println("Author ID does not exist to update.");
			   
	    }
		
		public static void updateBook(String bId, String bName) {
			List<Book> newBookList = BookDAO.readBook();
			        int location = 0;
			        
			        //check if author ID exists
			        for(Book checkId : newBookList) {
			            if(checkId.getBookId().equals(bId)) {
			            	location = newBookList.indexOf(checkId);// get index of the record to be updated
			            	newBookList.get(location).setBookName(bName); 
			            	BookDAO.writeBook(newBookList); 
			                return;
			            }
			        }
			        
			        System.out.println("Book ID does not exist to update.");
			   
	    }
		
		public static void updatePublisher(String pId, String pName, String pAddress) {
			
			List<Publisher> newPublisherList = PublisherDAO.readPublisher();
			        int location = 0;
			    
			        for(Publisher checkId : newPublisherList) {
			            if(checkId.getPublisherId().equals(pId)) {
			            	location = newPublisherList.indexOf(checkId);// get index of the record to be updated
			            	newPublisherList.get(location).setPublisherName(pName); 
			            	PublisherDAO.writePublisher(newPublisherList); 
			                return;
			            }
			        }
			        
			        System.out.println("Publisher ID does not exist to update.");
			   
	    }
		
		public static void deleteBook(String id) {
			List<Book> newBookList = BookDAO.readBook();
			
			for(Iterator<Book> checker =newBookList.iterator(); checker.hasNext(); )
	        {
	            Book newBook = checker.next();
	            if (newBook.getBookId().equals(id)) {
	            	checker.remove();
	            }
	        }
	        BookDAO.writeBook(newBookList);
	        
		        
	    }

		public static void deletePublisher(String id) {
			List<Book> newBookList = BookDAO.readBook();
			List<Publisher> newPublisherList = PublisherDAO.readPublisher();
		        
			for(Iterator<Book> checker =newBookList.iterator(); checker.hasNext(); )
	        {
	            Book newBook = checker.next();
	            if (newBook.getPublisherId().equals(id)) {
	            	checker.remove();
	            }
	        }
	        BookDAO.writeBook(newBookList);
	        
		        
		        for(Publisher checker:newPublisherList) {
		        	if (checker.getPublisherId().equals(id)) {
		        		newPublisherList.remove(checker);
		        		PublisherDAO.writePublisher(newPublisherList);
		        		return;
		        	}
		    }
		}
// static means you don't have to create instance and can be used anywhere
	public static void deleteAuthor(String id) {
		List<Book> newBookList = BookDAO.readBook();
		List<Author> newAuthorList = AuthorDAO.readAuthor();
	        
		 for(Iterator<Book> checker = newBookList.iterator(); checker.hasNext(); )
	        {
	            Book newBook = checker.next();
	            if (newBook.getAuthorId().equals(id)) {
	            	checker.remove();
	            }
	        }
	        BookDAO.writeBook(newBookList);
	        
	        
	        for(Author checker: newAuthorList) {
	        	if (checker.getAuthorId().equals(id)) {
	        		newAuthorList.remove(checker);
	        		AuthorDAO.writeAuthor(newAuthorList);
	        		return;
	        	}
	    }
	}

}