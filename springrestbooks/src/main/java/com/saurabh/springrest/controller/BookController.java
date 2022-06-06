package com.saurabh.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saurabh.springrest.entities.Book;
import com.saurabh.springrest.services.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}
	@GetMapping("/books/{id}")
	public Book getSingleBook(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	@PostMapping("/books")
	public void createBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id") int id) {
		bookService.deleteBook(id);
	}
	@PutMapping("books/{id}")
	public Book updateBook(@RequestBody Book book, @PathVariable("id") int id) {
		bookService.updateBook(book,id);
		return book;
	}
}
