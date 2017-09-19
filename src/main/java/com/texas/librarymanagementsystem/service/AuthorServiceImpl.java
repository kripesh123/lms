package com.texas.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.texas.librarymanagementsystem.dao.AuthorDAO;
import com.texas.librarymanagementsystem.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDAO authorDAO;
	
	@Override
	public void save(Author author) {
		authorDAO.save(author);
	}

	@Override
	public Author findOne(long id) {
		Author author =authorDAO.findOne(id);
		return author;
	}

	@Override
	public List<Author> findAll() {
		List<Author> authors = authorDAO.findAll();
		return authors;
	}

	@Override
	public List<Author> findByFirstNameAndLastName(String firstName, String lastName) {
		List<Author> authors = authorDAO.findByFirstNameAndLastName(firstName, lastName);
		return authors;
	}
}
