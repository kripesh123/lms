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

import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.API_VER;
import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.BOOK_PATH;

import com.texas.librarymanagementsystem.entity.Book;
import com.texas.librarymanagementsystem.service.BookService;

@RestController
@RequestMapping(API_VER + BOOK_PATH)
public class BookController {

	@Autowired
	private BookService bookService;
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody Book book){
		bookService.save(book);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/books",method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getAll(){
		List<Book> books =bookService.findAll();
		if(books == null || books.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(books,HttpStatus.FOUND);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable long id){
		Book book = bookService.findOne(id);
		if(book == null){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(book,HttpStatus.FOUND);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Book>> getBooks(@RequestParam(required=false) String name,@RequestParam(required=false) String author){
		List<Book> books = null;
		if(name != null){
			books = bookService.findByName(name);
		}else{
			books = bookService.findByAuthorName(name);
		}		
		if(books == null || books.isEmpty()){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(books,HttpStatus.FOUND);
	}	
}
