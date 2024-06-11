package com.book.BookManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.BookManager.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	

}
