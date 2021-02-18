package com.credibanco.assessment.library.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "AUTHOR", schema = "SYSTEM")
@Getter
@Setter
public class Author implements Serializable {

	private static final long serialVersionUID = -5330611443398731296L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AUTHOR")
	private Integer idAuthor;

	@Column(name = "FULLNAME")
	private String fullname;

	@Column(name = "BIRTHDATE")
	private Date birthdate;

	@Column(name = "BIRTH_CITY")
	private String birthCity;

	@Column(name = "EMAIL")
	private String email;

}
