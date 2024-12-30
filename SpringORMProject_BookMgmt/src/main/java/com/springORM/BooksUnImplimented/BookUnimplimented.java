package com.springORM.BooksUnImplimented;

import com.springORM.Entity.BookStore;

public interface BookUnimplimented 
{
	public int add(BookStore bs);
	
	public void change(BookStore bs);
	
	public int remove(int id);
	
	public void getBookByID(int id);
	
	public void showAllBooks();
}
