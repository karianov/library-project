package com.credibanco.assessment.library.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.service.EditorialService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "/rest/v1/editorial")
@Api(tags = { "Editorial" })
public class EditorialController {

	@Autowired
	private EditorialService editorialService;

	@GetMapping("/{idEditorial}")
	@ApiOperation(value = "Get one existing editorial", notes = "REST service to obtain one existing editorial")
	public ResponseEntity<EditorialDto> getEditorialById(@PathVariable Integer idEditorial) {
		return new ResponseEntity<EditorialDto>(editorialService.findEditorialById(idEditorial), HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation(value = "Get all existing editorials", notes = "REST service to obtain all existing editorials")
	public ResponseEntity<List<EditorialDto>> getAllEditorials() {
		return new ResponseEntity<List<EditorialDto>>(editorialService.findAllEditorials(), HttpStatus.OK);
	}

	@PostMapping
	@ApiOperation(value = "Create one editorial", notes = "REST service to insert new editorials")
	public ResponseEntity<EditorialDto> createEditorial(@Valid @RequestBody EditorialDto newEditorial) {
		return new ResponseEntity<EditorialDto>(editorialService.saveEditorial(newEditorial), HttpStatus.CREATED);
	}

	@PutMapping("/{idEditorial}")
	@ApiOperation(value = "Update an editorial", notes = "REST service to update a searched editorial")
	public ResponseEntity<EditorialDto> updateEditorial(@PathVariable Integer idEditorial, @Valid @RequestBody EditorialDto editorialToUpdate) {
		return new ResponseEntity<EditorialDto>(editorialService.updateEditorial(idEditorial, editorialToUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/{idEditorial}")
	@ApiOperation(value = "Delete an editorial", notes = "REST service to delete a searched editorial")
	public ResponseEntity<EditorialDto> deleteEditorial(@PathVariable Integer idEditorial) {
		return new ResponseEntity<EditorialDto>(editorialService.deleteEditorial(idEditorial), HttpStatus.OK);
	}
	
}
