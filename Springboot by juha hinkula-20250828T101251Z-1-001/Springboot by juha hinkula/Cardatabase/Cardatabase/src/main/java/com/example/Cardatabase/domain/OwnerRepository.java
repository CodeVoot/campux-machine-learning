package com.example.Cardatabase.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

                 // Service
public interface OwnerRepository extends CrudRepository<Owner, Long>{
		
	Optional<Owner> findByFirstName(String firstName);
}
