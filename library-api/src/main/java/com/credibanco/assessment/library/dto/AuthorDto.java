package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorDto implements Serializable {

	private static final long serialVersionUID = -2925096694843933L;

	private Integer idAuthor;

	@NotBlank(message = "El nombre del autor no puede ser vacío")
	@Size(max = 100, message = "El nombre del autor no puede exceder los 100 caracteres")
	private String fullname;

	private String birthdate;

	@Size(max = 45, message = "La ciudad natal del autor no puede exceder los 45 caracteres")
	private String birthCity;

	@Size(max = 65, message = "El correo electrónico del autor no puede exceder los 65 caracteres")
	private String email;

}
