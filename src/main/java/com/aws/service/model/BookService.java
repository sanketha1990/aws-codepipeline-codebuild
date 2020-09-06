package com.aws.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.aws.service.dto.Book;
import com.aws.service.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repository;

	public List<Book> getAllBooks() {
		List<Book> bookList = new ArrayList<Book>();
		repository.findAll().forEach(bookList::add);
		return bookList;
	}

	public Book getBookById(@PathVariable int id) {
		return repository.findById(id).get();
	}

	public Book saveBook(@RequestBody Book book) {
		return repository.save(book);
	}

	public Book updateBook(@RequestBody Book book) {

		Optional<Book> bookId = repository.findById(book.getId());
		if (bookId == null) {
			System.out.println("There is no book by this ID, So creating new book !!");
		}
		return repository.save(book);
	}

	public List<Book> saveAll(List<Book> books) {
		// TODO Auto-generated method stub
		return repository.saveAll(books);
	}

}
