package com.credibanco.assessment.library.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

	public Book findByIdBook(Integer idBook);
	
}
