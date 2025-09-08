package com.example.Cardatabase.Web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Cardatabase.domain.Car;
import com.example.Cardatabase.domain.CarRepository;

// Now we are saying that this class will be responsible to handle the Car HTTP requests
@RestController
public class CarController{
	
	private final CarRepository repository;
	
	public CarController(CarRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("/cars")
	public Iterable<Car> getCars(){
	    return repository.findAll();
	}
}
