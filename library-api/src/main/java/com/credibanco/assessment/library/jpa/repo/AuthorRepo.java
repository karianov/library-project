package com.credibanco.assessment.library.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Author;

public interface AuthorRepo extends JpaRepository<Author, Integer> {

	public Author findByIdAuthor(Integer idAuthor);

}
