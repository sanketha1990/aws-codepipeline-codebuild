package com.aws.service.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.service.dto.Book;
import com.aws.service.model.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable int id) {
		return service.getBookById(id);
	}

	@PostMapping("/save")
	public Book save(@RequestBody Book book) {
		return service.saveBook(book);
	}

	@PostMapping("/saveAll")
	public List<Book> saveAll(@RequestBody List<Book> books) {
		return service.saveAll(books);
	}

	@PutMapping("/update")
	public Book update(@RequestBody Book book) {
		return service.updateBook(book);
	}

	@GetMapping("/sortById")
	public List<Book> sortById(){
		return service.getAllBooks().stream().sorted(Comparator.comparing(Book::getId)).collect(Collectors.toList());
	}
}
