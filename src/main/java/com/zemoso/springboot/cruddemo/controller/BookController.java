package com.zemoso.springboot.cruddemo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zemoso.springboot.cruddemo.dto.BookDto;
import com.zemoso.springboot.cruddemo.entity.Book;
import com.zemoso.springboot.cruddemo.service.BookService;


@Controller
@RequestMapping("/books")
public class BookController {
	
	
	private BookService bookService;

	public BookController(BookService theBookService) {
		bookService = theBookService;
	}
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	// add mapping for "/list"
	@GetMapping("/")
	public String home(Model theModel) {
		
		return "home";
	}
	@GetMapping("/search")
	public String  searchTitle(Model theModel, @RequestParam("keyword") String keyword) {
		
		List<Book>  theBooks = bookService.findByTitle(keyword);
		
		// add to the spring model
		theModel.addAttribute("books", theBooks);
		
		return "list-books";
	}
	
	@GetMapping("/list")
	public String listBooks(Model theModel) {
		
		List<BookDto> theBooks = bookService.findAll();
		long count=bookService.count();
		// add to the spring model
		theModel.addAttribute("tcount",count);
		theModel.addAttribute("books", theBooks);
		
		return "list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Book theBook = new Book();
		
		theModel.addAttribute("book", theBook);
		
		return "book-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,
									Model theModel) {
		try {
		Book theBook = bookService.findById(theId);
		theModel.addAttribute("book", theBook);
		// send over to our form
		return "book-form";	
		}
		catch(Exception exc){
			System.out.println("id not found");
		}
		return "access-denied";
				
	}
	
	@PostMapping("/save")
	public String saveBook(@Valid @ModelAttribute("book") Book theBook, BindingResult theBindingResult,HttpSession session) {
			if(theBindingResult.hasErrors()) {
				return "book-form";
			}
			else {
				bookService.save(theBook);
				return "redirect:/books/list";
			}

	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		
		bookService.deleteById(theId);
		return "redirect:/books/list";
		
	}
	
	@GetMapping("/deleteAll")
	public String deleteAll(Model theModel) {
		bookService.deleteAll();
		return "redirect:/books/list";
	}
	
}
