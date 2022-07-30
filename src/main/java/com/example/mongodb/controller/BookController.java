package com.example.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongodb.models.Book;
import com.example.mongodb.repository.BookRepository;

@RestController
@RequestMapping("book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping()
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookRepository.findById(id).get();
	}
	
	@PostMapping()
	public String saveBook(@RequestBody Book book) {
		bookRepository.save(book);
		return "Added book with id "+book.getId();
	}
	
	@DeleteMapping("/{id}")
	public String deleteBook(@PathVariable("id") int id) {
		bookRepository.deleteById(id);
		return "Book deleted with id "+id;
	}
}
