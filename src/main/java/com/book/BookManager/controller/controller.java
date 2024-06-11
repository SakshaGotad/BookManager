package com.book.BookManager.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.book.BookManager.entity.Book;
import com.book.BookManager.entity.MyBookList;
import com.book.BookManager.service.BookService;
import com.book.BookManager.service.MyBookListService;

import java.util.*;

@Controller
public class controller {
     
	@Autowired
	private BookService service;
	
	@Autowired
	private MyBookListService myBookService;
	
    @GetMapping("/")
    public String home() {
        return "home";
    }


    @GetMapping("/book_Register")
    public String bookRegister() {
        return "bookRegister"; 
    }

    @GetMapping("/get_All_Books")
    public ModelAndView getAllBook() {
        List<Book>list = service.getAllBook();
//		
//		 ModelAndView m = new ModelAndView();
//		  
//		 m.setViewName("getAllBook");
//         m.addObject("book",list);
//		 
        return new ModelAndView("getAllBook","book",list);
    }
    @PostMapping("/save")
    
    public String addbook(@ModelAttribute Book b) {
    		service.save(b);
    		return "redirect:/get_All_Books";
    	}
   
    @GetMapping("/my_Books")
    public String getMyBooks(Model model) {
    	List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book",list);
		return "myBooks";
    }
    
    @RequestMapping("/myList/{id}")
    public String getMyList(@PathVariable("id") int id) {
    	service.getBookById(id);
    	Book b=service.getBookById(id);
    	MyBookList mb=new MyBookList(b.getId(),b.getName(),b.getAuthor(),b.getPrice());
		myBookService.saveMyBooks(mb);
    	return "redirect:/my_Books";
    }
    
    @RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		Book b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
    }
    

        @RequestMapping("/deleteBook/{id}")
        public String deleteBook(@PathVariable("id")int id) {
            service.deleteById(id);
            return "redirect:/get_All_Books";
        }
        
    

    
    
}
