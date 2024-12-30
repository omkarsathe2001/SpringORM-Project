package com.springORM.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookStore 
{
	@Id
	private int id;
	private String name;
	private String author;
	private double price;
	
	public BookStore() {
		super();
	}
	
	
	public BookStore(int id, String name, String author, double price) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
		return "BookStore [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
	

}
