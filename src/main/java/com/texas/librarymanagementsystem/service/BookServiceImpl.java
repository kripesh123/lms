package com.texas.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.librarymanagementsystem.dao.AuthorDAO;
import com.texas.librarymanagementsystem.dao.BookDAO;
import com.texas.librarymanagementsystem.entity.Author;
import com.texas.librarymanagementsystem.entity.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDAO bookDAO;
	
	@Autowired
	private AuthorDAO authorDAO;
	
	@Override
	public void save(Book book) {
		book.setStatus(true);
		Author author = authorDAO.findOne(book.getAuthor().getId());
		book.setAuthor(author);
		bookDAO.save(book);
	}

	@Override
	public Book findOne(long id) {
		Book book = bookDAO.findOne(id);
		return book;
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = bookDAO.findAll();
		return books;
	}

	@Override
	public List<Book> findByName(String name) {
		List<Book> books = bookDAO.findByName(name);
		return books;
	}

	@Override
	public List<Book> findByRackNumber(String rackNumber) {
		List<Book> books = bookDAO.findByRackNumber(rackNumber);
		return books;
	}

	@Override
	public List<Book> findByStatus(boolean status) {
		List<Book> books = bookDAO.findByStatus(status);
		return books;
	}

	@Override
	public List<Book> findByAuthor(Author author) {
		List<Book> books = bookDAO.findByAuthor(author);
		return books;
	}

}
