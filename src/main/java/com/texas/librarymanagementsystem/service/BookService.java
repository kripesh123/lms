package com.texas.librarymanagementsystem.service;

import java.util.List;

import com.texas.librarymanagementsystem.entity.Author;
import com.texas.librarymanagementsystem.entity.Book;

public interface BookService {
	void save(Book book);
	Book findOne(long id);
	List<Book> findAll();
	List<Book> findByName(String name);
	List<Book> findByRackNumber(String rackNumber);
	List<Book> findByStatus(boolean status);
	List<Book> findByAuthor(Author author);
	List<Book> findByAuthorName(String name);
	

}
