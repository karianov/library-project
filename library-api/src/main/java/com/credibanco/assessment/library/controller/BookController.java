package com.credibanco.assessment.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.service.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/rest/v1/book")
@Api(tags = { "Book" })
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/{idBook}")
	@ApiOperation(value = "Get one existing book", notes = "REST service to obtain one existing book")
	public ResponseEntity<BookDto> getBookById(@PathVariable Integer idBook) {
		return new ResponseEntity<BookDto>(bookService.findBookById(idBook), HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Get all existing books", notes = "REST service to obtain all existing books")
	public ResponseEntity<List<BookDto>> getAllBooks() {
		return new ResponseEntity<List<BookDto>>(bookService.findAllBooks(), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create one book", notes = "REST service to insert new books")
	public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto newBook) {
		return new ResponseEntity<BookDto>(bookService.saveBook(newBook), HttpStatus.CREATED);
	}

	@PutMapping("/{idBook}")
	@ApiOperation(value = "Update a book", notes = "REST service to update a searched book")
	public ResponseEntity<BookDto> updateBook(@PathVariable Integer idBook, @Valid @RequestBody BookDto bookToUpdate) {
		return new ResponseEntity<BookDto>(bookService.updateBook(idBook, bookToUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{idBook}")
	@ApiOperation(value = "Delete a book", notes = "REST service to delete a searched book")
	public ResponseEntity<BookDto> deleteBook(@PathVariable Integer idBook) {
		return new ResponseEntity<BookDto>(bookService.deleteBook(idBook), HttpStatus.OK);
	}
	
}
