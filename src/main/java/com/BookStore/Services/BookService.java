package com.BookStore.Services;

import java.util.List;

import com.BookStore.Model.Book;

public interface BookService {
	Book addBook(Book b);
	String searchBook(int id);
	List<String> searchAllBooks();
	//void addReview();
}
