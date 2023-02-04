package com.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "U_Table")
public class User {

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public LocalDate getTime() {
		return time;
	}

	public void setTime(LocalDate time) {
		this.time = time;
	}

	public LocalDate getSubmit_time() {
		return submit_time;
	}

	public void setSubmit_time(LocalDate submit_time) {
		this.submit_time = submit_time;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "uId")
	private int userId;

	@Column(name = "uName", length = 25)
	private String userName;

	@Column(name = "uAdd")
	private String address;

	@Column(name = "uContactNo")
	private long contactNo;

	@Column(name = "time")
	private LocalDate time;
	@Column(name = "submit_time")
	private LocalDate submit_time;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "B_FK_ID")
	private Book book;

	public User() {
		super();
	}

	public User(@NotNull int userId, String userName, String address, long contactNo, int book_No, LocalDate time,
			LocalDate submit_time) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.contactNo = contactNo;
		this.book = book;
		this.time = time;
		this.submit_time = submit_time;
	}

}
