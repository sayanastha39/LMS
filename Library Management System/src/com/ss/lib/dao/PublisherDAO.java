package com.ss.lib.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;	
import com.ss.entities.*;


public class PublisherDAO {
	
	
		public static List<Publisher>  readPublisher() {
				
				//For publisher csv file
				BufferedReader br = null;
				List<Publisher> publisherList = null;
	      	
	              try
	              {
	                  //Reading the csv file
	                  br = new BufferedReader(new FileReader("/Users/sayanashrestha/Documents/Publisher.csv"));
	                  
	                  //Create List for holding data in the file
	                  publisherList = new ArrayList<Publisher> (); 
	          		
	                  String line = ""; //store data from csv file
	                  
	                  //always skips a line
	                  br.readLine();
	                  
	                  //if second line is not null then
	                  while ((line = br.readLine()) != null) 
	                  {
	                      Publisher newPublisher = new Publisher(line); //calling constructor from entity main class
	                      publisherList.add(newPublisher);
	                  }
	                  
	                //Lets test the publisher List
	                 /*for(Publisher p : publisherList)
	                  {
	                      System.out.println(p.getPublisherId()+"   "+p.getPublisherName());
	                  }*/
	              }
	      	
	              catch(Exception pub)
	              {
	              	//understand where the actual problem occurred. It helps to trace the exception
	                  pub.printStackTrace();
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
	              return publisherList;
		}
		
		//writing a file
		public static void writePublisher(List<Publisher> publisherList) {
			
		//write to a file
	        BufferedWriter bw = null;
	       
	        StringBuilder sb = new StringBuilder();
	        
	        try {
	        	
	            bw = new BufferedWriter(new FileWriter("/Users/sayanashrestha/Documents/Publisher.csv"));
	            
	            sb.append("PublisherId,PublisherName, PublisherAddress\n"); //create headers in the new file 
	            
	            //output is reading values passed by CRUD in the publisherlist: 123 Oxford
	            for(Publisher output: publisherList) {
	            	
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