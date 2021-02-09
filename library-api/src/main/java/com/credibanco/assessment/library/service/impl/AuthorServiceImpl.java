package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.credibanco.assessment.library.dto.AuthorDto;
import com.credibanco.assessment.library.jpa.repo.AuthorRepo;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.service.AuthorService;
import com.credibanco.assessment.library.service.MapperService;

@Service(value = "authorService")
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	private AuthorRepo authorRepo;

	@Autowired
	private MapperService mapperService;
	
	@Override
	public AuthorDto findAuthorById(Integer idAuthor) {
		Author searchedAuthor = authorRepo.findByIdAuthor(idAuthor);
		if (searchedAuthor != null) {
			return mapperService.map(searchedAuthor, AuthorDto.class);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El autor " + idAuthor + " no existe.");
		}
	}

	@Override
	public List<AuthorDto> findAllAuthors() {
		return mapperService.mapList(authorRepo.findAll(), AuthorDto.class);
	}

	@Override
	public AuthorDto saveAuthor(AuthorDto newAuthor) {
		try {
			Author authorToCreate = mapperService.map(newAuthor, Author.class);
			authorToCreate.setIdAuthor(null);
			return mapperService.map(authorRepo.save(authorToCreate), AuthorDto.class);
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor no pudo guardarse debido a los valores de entrada.");
		}
	}

	@Override
	public AuthorDto updateAuthor(Integer idAuthor, AuthorDto authorToUpdate) {
		findAuthorById(idAuthor);
		Author updatedAuthor = mapperService.map(authorToUpdate, Author.class);
		updatedAuthor.setIdAuthor(idAuthor);
		try {
			return mapperService.map(authorRepo.save(updatedAuthor), AuthorDto.class);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"El autor " + idAuthor + " no pudo actualizarse debido a los valores ingresados.");
		}
	}

	@Override
	public AuthorDto deleteAuthor(Integer idAuthor) {
		AuthorDto deletedAuthor = findAuthorById(idAuthor);
		try {
			authorRepo.deleteById(idAuthor);
			return deletedAuthor;
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor " + idAuthor + " no pudo ser borrado.");
		}
	}

}
