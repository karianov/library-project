package com.credibanco.assessment.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.jpa.repo.BookRepo;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.service.AuthorService;
import com.credibanco.assessment.library.service.BookService;
import com.credibanco.assessment.library.service.EditorialService;
import com.credibanco.assessment.library.service.MapperService;

@Service(value = "bookService")
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepo bookRepo;

	@Autowired
	private EditorialService editorialService;

	@Autowired
	private MapperService mapperService;

	@Override
	public BookDto findBookById(Integer idBook) {
		Book searchedBook = bookRepo.findByIdBook(idBook);
		if (searchedBook != null) {
			return mapperService.map(searchedBook, BookDto.class);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "El libro " + idBook + " no existe.");
		}
	}

	@Override
	public List<BookDto> findAllBooks() {
		return mapperService.mapList(bookRepo.findAll(), BookDto.class);
	}

	@Override
	public List<BookDto> findBooks(String criteria) {
		try {
			List<BookDto> books = new ArrayList<BookDto>();
			List<BookDto> localBooks = mapperService.mapList(bookRepo.findAll(), BookDto.class);
			for (BookDto book : localBooks) {
				if (book.getTitle().contains(criteria)) {
					books.add(book);
				}
			}
			return books;
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"No fue posible encontrar libros con la palabra " + criteria + ".");
		}
	}

	@Override
	public BookDto saveBook(BookDto newBook) {
		try {
			Integer numberOfBooks = bookRepo.findAll().size();
			EditorialDto editorialDestination = editorialService
					.findEditorialById(newBook.getEditorial().getIdEditorial());
			if (numberOfBooks < editorialDestination.getMaxBooksReg()) {
				Book bookToCreate = mapperService.map(newBook, Book.class);
				bookToCreate.setIdBook(null);
				return mapperService.map(bookRepo.save(bookToCreate), BookDto.class);
			} else {
				throw new ResponseStatusException(HttpStatus.CONFLICT, "La editorial " + editorialDestination.getName()
						+ " no puede registrar más de " + editorialDestination.getMaxBooksReg() + " libros.");
			}
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"El libro no pudo guardarse debido a los valores de entrada.");
		}
	}

	@Override
	public BookDto updateBook(Integer idBook, BookDto bookToUpdate) {
		findBookById(idBook);
		Book updatedBook = mapperService.map(bookToUpdate, Book.class);
		updatedBook.setIdBook(idBook);
		try {
			return mapperService.map(bookRepo.save(updatedBook), BookDto.class);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"El libro " + idBook + " no pudo actualizarse debido a los valores ingresados.");
		}
	}

	@Override
	public BookDto deleteBook(Integer idBook) {
		BookDto deletedBook = findBookById(idBook);
		try {
			bookRepo.deleteById(idBook);
			return deletedBook;
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El libro " + idBook + " no pudo ser borrado.");
		}
	}

}
