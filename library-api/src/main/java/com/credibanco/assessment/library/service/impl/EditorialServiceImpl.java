package com.credibanco.assessment.library.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.jpa.repo.EditorialRepo;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.service.EditorialService;
import com.credibanco.assessment.library.service.MapperService;

@Service(value = "editorialService")
public class EditorialServiceImpl implements EditorialService {

	@Autowired
	private EditorialRepo editorialRepo;

	@Autowired
	private MapperService mapperService;
	
	@Override
	public EditorialDto findEditorialById(Integer idEditorial) {
		Editorial searchedEditorial = editorialRepo.findByIdEditorial(idEditorial);
		if (searchedEditorial != null) {
			return mapperService.map(searchedEditorial, EditorialDto.class);
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "La editorial " + idEditorial + " no existe.");
		}
	}

	@Override
	public List<EditorialDto> findAllEditorials() {
		return mapperService.mapList(editorialRepo.findAll(), EditorialDto.class);
	}

	@Override
	public EditorialDto saveEditorial(EditorialDto newEditorial) {
		try {
			Editorial editorialToCreate = mapperService.map(newEditorial, Editorial.class);
			editorialToCreate.setIdEditorial(null);
			return mapperService.map(editorialRepo.save(editorialToCreate), EditorialDto.class);
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La editorial no pudo guardarse debido a los valores de entrada.");
		}
	}

	@Override
	public EditorialDto updateEditorial(Integer idEditorial, EditorialDto editorialToUpdate) {
		findEditorialById(idEditorial);
		Editorial updatedEditorial = mapperService.map(editorialToUpdate, Editorial.class);
		updatedEditorial.setIdEditorial(idEditorial);
		try {
			return mapperService.map(editorialRepo.save(updatedEditorial), EditorialDto.class);
		} catch (Exception exception) {
			throw new ResponseStatusException(HttpStatus.CONFLICT,
					"La editorial " + idEditorial + " no pudo actualizarse debido a los valores ingresados.");
		}
	}

	@Override
	public EditorialDto deleteEditorial(Integer idEditorial) {
		EditorialDto deletedEditorial = findEditorialById(idEditorial);
		try {
			editorialRepo.deleteById(idEditorial);
			return deletedEditorial;
		} catch (Exception exception) {
			System.out.println(exception);
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La editorial " + idEditorial + " no pudo ser borrada.");
		}
	}

}
