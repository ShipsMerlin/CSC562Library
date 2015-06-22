package model;

import static org.junit.Assert.*;

import org.junit.Test;

import datasource.DatabaseException;

public class TestBookList {

	@Test
	public void testAddBook() {
		BookList bookList = new BookList();
		String isbn = bookList.addBook("1234567890", "Test Book", "Test Author");
		
		assertEquals("1234567890", isbn);
	}

	@Test
	public void testGetBook() throws DatabaseException {
		BookList bookList = new BookList();
		String isbn = bookList.addBook("1234567890", "Test Book", "Test Author");
		String isbn2 = bookList.getBook("1234567890");
		
	}
}
