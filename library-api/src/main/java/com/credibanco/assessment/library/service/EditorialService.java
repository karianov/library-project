package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.dto.EditorialDto;

public interface EditorialService {

	public EditorialDto findEditorialById(Integer idEditorial);

	public List<EditorialDto> findAllEditorials();

	public EditorialDto saveEditorial(EditorialDto newEditorial);

	public EditorialDto updateEditorial(Integer idEditorial, EditorialDto editorialToUpdate);

	public EditorialDto deleteEditorial(Integer idEditorial);
	
}
