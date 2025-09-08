package com.example.Cardatabase.domain;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

// to turn off to show the appusers to everyone from REST services
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface AppUserRepository extends CrudRepository<AppUser, Long>{
	Optional<AppUser> findByUsername(String username);
	
	boolean existsByUsername(String username); // <-- Add this line
}
