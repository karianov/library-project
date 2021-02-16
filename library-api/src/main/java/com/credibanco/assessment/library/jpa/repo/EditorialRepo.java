package com.credibanco.assessment.library.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Editorial;

public interface EditorialRepo extends JpaRepository<Editorial, Integer> {

	public Editorial findByIdEditorial(Integer idEditorial);

}
