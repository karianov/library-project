package com.credibanco.assessment.library.dto;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditorialDto implements Serializable {

	private static final long serialVersionUID = -2925096694843933L;

	private Integer idEditorial;

	@NotBlank(message = "El nombre de la editorial no puede ser vacío")
	@Size(max = 100, message = "El nombre de la editorial no puede exceder los 100 caracteres")
	private String name;

	@NotBlank(message = "La dirección de la editorial no puede ser vacía")
	@Size(max = 45, message = "La dirección de la editorial no puede exceder los 45 caracteres")
	private String address;

	@NotBlank(message = "El teléfono de la editorial no puede ser vacía")
	@Size(max = 60, message = "El teléfono de la editorial no puede exceder los 60 caracteres")
	private String phone;

	@Size(max = 45, message = "El correo electrónico de la editorial no puede exceder los 45 caracteres")
	private String email;

	@NotBlank(message = "El máximo número de libros de la editorial no puede ser vacía")
	@Min(value = -1, message = "El máximo número de libros de la editorial no puede ser un número negativo")
	private Integer maxBooksReg;
	
}
