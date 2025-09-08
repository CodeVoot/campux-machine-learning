package com.example.Cardatabase;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Cardatabase.domain.AppUserRepository;
import com.example.Cardatabase.domain.Car;
import com.example.Cardatabase.domain.CarRepository;
import com.example.Cardatabase.domain.Owner;
import com.example.Cardatabase.domain.OwnerRepository;
import com.example.Cardatabase.domain.AppUser;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication // Client for Car repository as well as Owner repository
public class CardatabaseApplication implements CommandLineRunner{
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	private final CarRepository repository;
	private final OwnerRepository orepository;
	private final AppUserRepository urepository;
	
	// constructor injection to access the database 
	public CardatabaseApplication(CarRepository repository,OwnerRepository orepository,AppUserRepository
			                            urepository) {
		this.repository = repository;
		this.orepository = orepository;
		this.urepository = urepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args); // automatically restart the application if we do  
		                                                            // any changes in the code 
		logger.info("Application Started");
	}

	@Override
	public void run(String... args) throws Exception {
		
		Owner owner1 = new Owner("John","Johnson");
		Owner owner2 = new Owner("Mary","Robinson");
		orepository.saveAll(Arrays.asList(owner1,owner2));
		
		repository.save(new Car("Ford","Mustang","Red","ADF-11241",2024,1751827,owner1));
		repository.save(new Car("Ford","Ferrari","Black","BDF-21421",2022,2751827,owner2));
		
		// logger info to print the all cars and print into the console
		for(Car car:repository.findAll()) {
			logger.info("brand: {} , model: {}",car.getBrand(),car.getModel());
		}
		
		
		 // Save users only if they don't exist
		
		// Username: user, password: user
	    if (!urepository.existsByUsername("user")) {
	        urepository.save(new AppUser("user",
	            "$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue",
	            "USER"));
	    }
	    
		// Username: admin, password: admin
	    if (!urepository.existsByUsername("admin")) {
	        urepository.save(new AppUser("admin",
	            "$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW",
	            "ADMIN"));
	    }
		
		
	}
	
}











