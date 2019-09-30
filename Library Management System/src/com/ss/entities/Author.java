package com.ss.entities;

public class Author {
	
	//declare variables
	
	private String authorId;
	private String authorName;
	
	public Author(String authorData){
        String[] authorArray = authorData.split(",", 2); 

        authorId = authorArray[0];
        authorName = authorArray[1];
    
    }
	

	// default constructor
	public Author() {
		
	}
	
	//Parameterized constructor
	public Author(String authorId, String authorName) {
		this.authorId = authorId;
		this.authorName = authorName;
	}

	//Getters and setters
	public String getAuthorId() {
		return authorId;
	}

	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getAuthorName() {
		return authorName;
	}

	
	public String convertCSV() {
		return authorId + ", " + authorName;
		
	}
	
	

}
