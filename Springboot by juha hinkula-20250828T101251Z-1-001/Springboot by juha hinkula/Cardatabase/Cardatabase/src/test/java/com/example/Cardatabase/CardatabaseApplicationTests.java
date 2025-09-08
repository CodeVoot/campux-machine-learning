package com.example.Cardatabase;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Cardatabase.Web.CarController;


@SpringBootTest
class CardatabaseApplicationTests {
	
	@Autowired
	private CarController carController;

	@Test
	@DisplayName("First Test case for this application")
	void contextLoads() {
		assertThat(carController).isNotNull();
	}

}
