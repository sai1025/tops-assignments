package com.contact.app.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import com.contact.app.entities.Contact;

public interface ContactRepository extends CrudRepository<Contact, Integer> {
	
	public Page<Contact> findContactsByUserId(int userID,Pageable pageable);

}
