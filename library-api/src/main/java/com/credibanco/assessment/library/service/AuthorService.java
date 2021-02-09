package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.dto.AuthorDto;

public interface AuthorService {

	public AuthorDto findAuthorById(Integer idAuthor);

	public List<AuthorDto> findAllAuthors();

	public AuthorDto saveAuthor(AuthorDto newAuthor);

	public AuthorDto updateAuthor(Integer idAuthor, AuthorDto authorToUpdate);

	public AuthorDto deleteAuthor(Integer idAuthor);
	
}
