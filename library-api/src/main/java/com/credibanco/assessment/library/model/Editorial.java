package com.credibanco.assessment.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EDITORIAL", schema = "SYSTEM")
@Getter
@Setter
public class Editorial implements Serializable {

	private static final long serialVersionUID = -5330611443398731296L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_EDITORIAL")
	private Integer idEditorial;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "MAX_BOOKS_REG")
	private Integer maxBooksReg;
	
}
