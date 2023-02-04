package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "B_Table")
public class Book {
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bId")
	private int bookId;

	@Column(name = "bookType")
	private String bookType;

	@Column(name = "bName")
	private String bName;

	@Column(name = "author")
	private String bAuthor;

	@Column(name = "price")
	private double bPrice;

	public Book() {
		super();
	}

	public Book(@NotNull int bookId, String bookType, String bName, String bAuthor, double bPrice) {
		super();
		this.bookId = bookId;
		this.bookType = bookType;
		this.bName = bName;
		this.bAuthor = bAuthor;
		this.bPrice = bPrice;
	}

}
