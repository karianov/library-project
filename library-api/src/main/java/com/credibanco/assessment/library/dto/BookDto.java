package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDto implements Serializable {

	private static final long serialVersionUID = -8104360397546025892L;

	private Integer idBook;

	@NotBlank(message = "El título del libro no puede ser vacío")
	@Size(max = 100, message = "El título del libro no puede exceder los 100 caracteres")
	private String title;

	private Integer year;

	@NotBlank(message = "El género del libro no puede ser vacío")
	@Size(max = 45, message = "El género del libro no puede exceder los 100 caracteres")
	private String genre;

	@NotNull(message = "El número de páginas del libro no puede ser vacío")
	private Integer pages;

	@NotNull(message = "El autor del libro no puede ser vacío")
	private AuthorDto author;

	private EditorialDto editorial;

}
