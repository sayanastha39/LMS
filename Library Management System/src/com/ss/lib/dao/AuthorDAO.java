package com.ss.lib.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;	
import com.ss.entities.*;


public class AuthorDAO {

		public static List<Author> readAuthor() {
		
			//reads text from a character-input stream/ bufferreader is synchronized
			BufferedReader br = null;
			
			//to access List outside of try catch
			List<Author> authorList =null;
			
	        try
	        {
	            //Reading the csv file
	            br = new BufferedReader(new FileReader("/Users/sayanashrestha/Documents/Author.csv"));
	            
	            //Create List for holding data in the file
	            authorList = new ArrayList<Author> (); 
	            
	            String line = ""; //store data from csv file
	            
	            //always skips a line
	            br.readLine();
	            
	            //if second line is not null then
	            while ((line = br.readLine()) != null) 
	            {
	                Author newAuthor = new Author(line); //calling constructor from entity main class
	                authorList.add(newAuthor);
	            }
	        }
		
	        catch(Exception au)
	        {
	        	//understand where the actual problem occurred. It helps to trace the exception
	            au.printStackTrace();
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
	        return  authorList;
        
		}      
        
		
		//writing a file
		public static void writeAuthor(List<Author> authorList) {
		//write to a file
	        BufferedWriter bw = null;
	       
	        StringBuilder sb = new StringBuilder();
	        
	        try {
	        	
	            bw = new BufferedWriter(new FileWriter("/Users/sayanashrestha/Documents/Author.csv"));
	            
	            sb.append("AuthorID,AuthorName\n"); //create headers in the new file 
	            
	            //output is reading values passed by CRUD in the authorlist: 123 sayana
	            for(Author output: authorList) {
	            	
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