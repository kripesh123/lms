package com.texas.librarymanagementsystem.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texas.librarymanagementsystem.entity.Author;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Long>{

	List<Author> findByFirstNameAndLastName(String firstName,String lastName);
}
