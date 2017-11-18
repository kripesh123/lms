package com.texas.librarymanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.texas.librarymanagementsystem.entity.Author;
import com.texas.librarymanagementsystem.entity.Book;

@Repository
public interface BookDAO extends JpaRepository<Book, Long>{

	List<Book> findByName(String name);
	List<Book> findByRackNumber(String rackNumber);
	List<Book> findByStatus(boolean status);
	List<Book> findByAuthor(Author author);
	@Query("SELECT b FROM Book b WHERE b.author.firstName = :firstName")
	List<Book> findByAuthorFirstName(@Param("firstName") String firstName);
}
