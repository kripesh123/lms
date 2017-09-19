package com.texas.librarymanagementsystem.service;

import java.util.List;

import com.texas.librarymanagementsystem.entity.Author;

public interface AuthorService {

	void save(Author author);
	Author findOne(long id);
	List<Author> findAll();
	List<Author> findByFirstNameAndLastName(String firstName,String lastName);
}
