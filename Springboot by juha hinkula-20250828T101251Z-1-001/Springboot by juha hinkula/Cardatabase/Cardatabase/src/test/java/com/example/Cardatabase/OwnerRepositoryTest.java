package com.example.Cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Cardatabase.domain.Owner;
import com.example.Cardatabase.domain.OwnerRepository;

@DataJpaTest
public class OwnerRepositoryTest {
	@Autowired
	private OwnerRepository repository;
	
	@Test
	void saveOwner() {
		repository.save(new Owner("Lucy","Smith"));
		assertThat(
				repository.findByFirstName("Lucy").isPresent()).isTrue();
			
	}
	
	// similarly we can create the test cases for other methods
	// like delete update retrieve as well
	
}
