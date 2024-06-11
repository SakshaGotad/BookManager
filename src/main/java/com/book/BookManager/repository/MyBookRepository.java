package com.book.BookManager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.BookManager.entity.MyBookList;

@Repository
public interface MyBookRepository extends JpaRepository<MyBookList,Integer> {

}
