package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.dto.BookDto;

public interface BookService {

	public BookDto findBookById(Integer idBook);

	public List<BookDto> findAllBooks();

	public BookDto saveBook(BookDto newBook);

	public BookDto updateBook(Integer idBook, BookDto bookToUpdate);

	public BookDto deleteBook(Integer idBook);

}
