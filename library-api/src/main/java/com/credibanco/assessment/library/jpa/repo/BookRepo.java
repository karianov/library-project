package com.credibanco.assessment.library.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.credibanco.assessment.library.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer> {

	public Book findByIdBook(Integer idBook);
	
	@Query(value = "SELECT COUNT(*) FROM SYSTEM.BOOK AS B WHERE B.ID_EDITORIAL = ?1", nativeQuery = true)
	public Integer findNumberOfBooksFromEditorial(Integer idEditorial);
	
}
