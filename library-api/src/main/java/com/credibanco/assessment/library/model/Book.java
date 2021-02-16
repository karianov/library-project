package com.credibanco.assessment.library.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "BOOK", schema = "SYSTEM")
@Getter
@Setter
public class Book implements Serializable {

	private static final long serialVersionUID = 6243019066186105784L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_BOOK")
	private Integer idBook;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "YEAR")
	private Integer year;
	
	@Column(name = "GENRE")
	private String genre;
	
	@Column(name = "PAGES")
	private Integer pages;

	@ManyToOne
	@JoinColumn(name = "ID_AUTHOR")
	private Author author;

	@ManyToOne
	@JoinColumn(name = "ID_EDITORIAL")
	private Editorial editorial;
}
