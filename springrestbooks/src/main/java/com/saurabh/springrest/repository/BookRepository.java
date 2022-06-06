package com.saurabh.springrest.repository;

import org.springframework.data.repository.CrudRepository;

import com.saurabh.springrest.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	
}
