package com.ss.entities;

public class Publisher {

	//declare variables
	private String publisherName;
	private String publisherId;
	private String publisherAddress;
	
	public Publisher(String publisherData){
        String[] publisherArray = publisherData.split(",", 3); 

        publisherId = publisherArray[0];
        publisherName = publisherArray[1];
        publisherAddress = publisherArray[2];
    
    }
	
	
	// default constructor

	public Publisher() {
	
	}

	//Parameterized constructor

	public Publisher ( String publisherId, String publisherName, String publisherAddress) {
	
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}

	//Getters and setters
	public void setPublisherId(String publisherId) {
		this.publisherId = publisherId;
	}

	public String getPublisherId() {
		return publisherId;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}


	public String getPublisherName() {
		return publisherName;
	}

	
	
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}


	public String getpublisherAddress() {
		return publisherAddress;
	}
	
	public String convertCSV() {
		return publisherId + ", " + publisherName+ ", " + publisherAddress;
		
	}
}
