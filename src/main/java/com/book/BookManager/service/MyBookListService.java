package com.book.BookManager.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.BookManager.entity.MyBookList;
import com.book.BookManager.repository.MyBookRepository;
@Service
public class MyBookListService {

	@Autowired
	private MyBookRepository mybook;
	public void saveMyBooks(MyBookList book) {
	mybook.save(book);
	}
	
	public List<MyBookList> getAllMyBooks(){
		return mybook.findAll();
	}

	public void deleteById(int id) {
		mybook.deleteById(id);
	}
}
