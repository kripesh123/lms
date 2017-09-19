package com.texas.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.texas.librarymanagementsystem.entity.Author;
import com.texas.librarymanagementsystem.service.AuthorService;

@RestController
@RequestMapping("/author")
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Author author){
		authorService.save(author);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/authors",method=RequestMethod.GET)
	public ResponseEntity<List<Author>> getAll(){
		List<Author> authors =authorService.findAll();
		if(authors == null || authors.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(authors,HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Author> getAuthor(@PathVariable long id){
		Author author = authorService.findOne(id);
		if(author == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(author,HttpStatus.FOUND);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Author>> getAuthors(@RequestParam String firstName,@RequestParam String lastName){
		List<Author> authors = authorService.findByFirstNameAndLastName(firstName, lastName);
		if(authors == null || authors.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(authors,HttpStatus.FOUND);
	}
	
	
}
