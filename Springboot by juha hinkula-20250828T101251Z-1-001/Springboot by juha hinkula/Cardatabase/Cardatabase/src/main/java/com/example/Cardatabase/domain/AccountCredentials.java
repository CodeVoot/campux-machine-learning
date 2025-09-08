package com.example.Cardatabase.domain;


// In Java, a record is a special type of class introduced in Java 14 (preview) 
// and officially added in Java 16. 
// It is used to create immutable data-carrying classes with minimal boilerplate.

// fields are final and private by default 

// we are using this class to store the credentials name and password 

public record AccountCredentials(String username,String password) {
	
	

}
