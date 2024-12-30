package com.springORM.BooksImplemented;

import java.util.List;


import org.springframework.orm.hibernate5.HibernateTemplate;

import com.springORM.BooksUnImplimented.BookUnimplimented;
import com.springORM.Entity.BookStore;

import jakarta.transaction.Transactional;

public class BookImplemented implements BookUnimplimented
{
	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Transactional
	public int add(BookStore bs)
	{
		Integer row = (Integer) hibernateTemplate.save(bs);
		return row;
	}

	@Transactional
	public void change(BookStore bs)
	{
		hibernateTemplate.update(bs);
	}

	@Transactional
	public int remove(int id) 
	{
		BookStore bs = hibernateTemplate.get(BookStore.class, id);
		hibernateTemplate.delete(bs);
		return 0;
	}

	@Transactional
	public void getBookByID(int id)
	{
		BookStore bs = hibernateTemplate.get(BookStore.class, id);
		System.out.println(bs);
	}

	@Transactional
	public void showAllBooks()
	{
		List<BookStore> list = hibernateTemplate.loadAll(BookStore.class);
	    
	    if (list.isEmpty()) {
	        System.out.println("No books found in the database.");
	        return;
	    }

	    // Print the table header
	    System.out.printf("%-10s %-30s %-30s %-10s\n", "ID", "Name", "Author", "Price");
	    System.out.println("------------------------------------------------------------------------------------");

	    // Print each book's details in a row
	    for (BookStore book : list) {
	        System.out.printf("%-10d %-30s %-30s %-10.2f\n", book.getId(), book.getName(), book.getAuthor(), book.getPrice());
	    }
	}

}
