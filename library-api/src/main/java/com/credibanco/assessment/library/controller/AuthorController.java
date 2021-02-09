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

import com.credibanco.assessment.library.dto.AuthorDto;
import com.credibanco.assessment.library.service.AuthorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/rest/v1/author")
@Api(tags = { "Author" })
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@GetMapping("/{idAuthor}")
	@ApiOperation(value = "Get one existing author", notes = "REST service to obtain one existing author")
	public ResponseEntity<AuthorDto> getAuthorById(@PathVariable Integer idAuthor) {
		return new ResponseEntity<AuthorDto>(authorService.findAuthorById(idAuthor), HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Get all existing authors", notes = "REST service to obtain all existing authors")
	public ResponseEntity<List<AuthorDto>> getAllAuthors() {
		return new ResponseEntity<List<AuthorDto>>(authorService.findAllAuthors(), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create one author", notes = "REST service to insert new authors")
	public ResponseEntity<AuthorDto> createAuthor(@Valid @RequestBody AuthorDto newAuthor) {
		return new ResponseEntity<AuthorDto>(authorService.saveAuthor(newAuthor), HttpStatus.CREATED);
	}

	@PutMapping("/{idAuthor}")
	@ApiOperation(value = "Update an author", notes = "REST service to update a searched author")
	public ResponseEntity<AuthorDto> updateAuthor(@PathVariable Integer idAuthor, @Valid @RequestBody AuthorDto authorToUpdate) {
		return new ResponseEntity<AuthorDto>(authorService.updateAuthor(idAuthor, authorToUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{idAuthor}")
	@ApiOperation(value = "Delete an author", notes = "REST service to delete a searched author")
	public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable Integer idAuthor) {
		return new ResponseEntity<AuthorDto>(authorService.deleteAuthor(idAuthor), HttpStatus.OK);
	}
	
}
