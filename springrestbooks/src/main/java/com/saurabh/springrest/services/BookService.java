package com.saurabh.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saurabh.springrest.entities.Book;
import com.saurabh.springrest.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository br;
	
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>)br.findAll();
		return list;
	}
	public Book getBookById(int id) {
		Book book = br.findById(id).get();
		return book;
	}
	public void addBook(Book b) {
		Book book = br.save(b);
	}
	public void deleteBook(int id) {
		br.deleteById(id);
	}
	public void updateBook(Book book, int id) {
		Book b = br.findById(id).get();
		if(b!=null) {
			b.setId(book.getId());
			b.setName(book.getName());
			b.setAuthor(book.getAuthor());
			b.setPrice(book.getPrice());
			br.save(b);
		}
	}
}
