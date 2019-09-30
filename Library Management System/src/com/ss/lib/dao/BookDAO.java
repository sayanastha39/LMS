package com.ss.lib.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;	
import com.ss.entities.*;


public class BookDAO {
	
		
		public static  List<Book> readBook() {
			
			//For book csv file
			BufferedReader br = null;
			 List<Book> bookList= null; 
      	
              try
              {
                  //Reading the csv file
                  br = new BufferedReader(new FileReader("/Users/sayanashrestha/Documents/Book.csv"));
                  
                  //Create List for holding data in the file
                 bookList = new ArrayList<Book> (); 
          		
                  String line = ""; //store data from csv file
                  
                  //always skips a line
                  br.readLine();
                  
                  //if second line is not null then
                  while ((line = br.readLine()) != null) 
                  {
                	  Book newBook = new Book(line); //calling constructor from entity main class
                	  bookList.add(newBook);
                  }
                  
               
              }
      	
              catch(Exception b)
              {
              	//understand where the actual problem occurred. It helps to trace the exception
                  b.printStackTrace();
              }
              
              finally
              {
                  try
                  {
                      br.close();
                  }
                  catch(IOException ie)
                  {
                      System.out.println("Error occured while closing the BufferedReader");
                      ie.printStackTrace();
                  }
              }
              return bookList;        
      
	}
		
		//writing a file
		public static void writeBook(List<Book> bookList) {
		//write to a file
	        BufferedWriter bw = null;
	       
	        StringBuilder sb = new StringBuilder();
	        
	        try {
	        	
	            bw = new BufferedWriter(new FileWriter("/Users/sayanashrestha/Documents/Book.csv"));
	            
	            sb.append("BookID,BookName, AuthorId, PublisherId\n"); //create headers in the new file 
	            
	            //output is reading values passed by CRUD in the booklist: 123 science 2 3
	            for(Book output: bookList) {
	            	
	            	//convertCSV  is a method to put string in form of csv
	            
	                sb.append(output.convertCSV() + "\n");
	            }
	            //once loop is completed it converts sb to string and write in the file
	            bw.write(sb.toString());
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        } 
	        finally {
	            try {
	                bw.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
}
}