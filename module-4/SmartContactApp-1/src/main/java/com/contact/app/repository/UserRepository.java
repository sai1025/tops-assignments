package com.contact.app.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.contact.app.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public Optional<User> findUserByEmail(String username);
	
	
}
