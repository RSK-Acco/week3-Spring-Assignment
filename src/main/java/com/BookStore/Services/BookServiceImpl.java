package com.BookStore.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.BokStore.Exception.UserException;
import com.BookStore.Model.Book;
import com.BookStore.Model.User;
import com.BookStore.Repository.BookRepository;
import com.BookStore.Repository.InventoryRepository;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired private BookRepository br;
	@Autowired private InventoryRepository ir;
	@Override
	public Book addBook(Book b) {
		return this.br.save(b);
	}
	
	@Override
	public String searchBook(int id) {
		Optional<Book> book=this.br.findById(id);
		if(book.isPresent()) {
			if((this.ir.findById(book.get().getBookId()).get().getBookCount()==0)) return book.get().toString()+"---Out of Stock---";
			else return book.get().toString();
		}
		else throw new UserException("User is not found");
	}
	@Override
	public List<String> searchAllBooks() {
		List<Book> allBooks=this.br.findAll();
		List<String> ans=new ArrayList<>();
		for(Book b:allBooks) {
			if((this.ir.findById(b.getBookId())).get().getBookCount()==0) {
				ans.add(b.toString()+" ---- Out of Stock---");
			}else ans.add(b.toString());
		}
		return ans;
	}

//	@Override
//	public void addReview() {
//		
//		System.out.println("hiii");
//	}

}
