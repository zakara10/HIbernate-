package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hql_book")
public class Book {
	@Id
	@GeneratedValue //increment generator class
	@Column(name="bkcode")	
	private int bookCode;
	
	@Column(name="bktitle",length=25)
	private String title;
	
	@Column(name="bkauthor",length=10)
	private String author;
	
	@Column(name="bkprice")
	private double price;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Book(int bookCode, String title, String author, double price) {
		super();
		this.bookCode = bookCode;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public Book( String title, String author, double price) {
		super();		
		this.title = title;
		this.author = author;
		this.price = price;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Book [bookCode=" + bookCode + ", title=" + title + ", author="
				+ author + ", price=" + price + "]";
	}
	
	
	
}
