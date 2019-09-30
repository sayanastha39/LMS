package com.ss.entities;

public class Book {
	
	//declare variables
	private String bookId;
	private String bookName;
	private String authorId;
	private String publisherId;
	
	
	public Book(String bookData){
        String[] bookArray = bookData.split(",", 4); 

        bookId = bookArray[0];
        bookName = bookArray[1];
        authorId = bookArray[2];
        publisherId = bookArray[3];
    }

	// default constructor
	public Book() {
		
	}
	
	//Parameterized constructor
	public Book(String bookId, String bookName, String authorId, String publisherId) {
		this.bookId = bookId;
		this.bookName = bookName;
		this.authorId = authorId;
		this.publisherId = publisherId;
	}

	//Getters and setters
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public String getBookId() {
		return bookId;
	}
	
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	public String getBookName() {
		return bookName;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	public String getAuthorId() {
		return authorId;
	}


	

	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}
	
	public String getPublisherId() {
		return publisherId;
	}
	
	public String convertCSV() {
		return bookId + ", " + bookName+ ", " + authorId+ ", " + publisherId;
		
	}
	
	

}
