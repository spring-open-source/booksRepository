package com.hardik.bookrepository.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hardik.bookrepository.service.BookService;

@Controller
public class ResultController {
	
	
	private BookService books;
	
	@Autowired
	public ResultController(BookService books) {
		super();
		this.books = books;
	}

	@PostMapping("/result")
	public Object showResult(@RequestParam("searchQuery")String searchQuery,Model model) {
		model.addAttribute("books", books.getBooks(searchQuery,"0"));
		model.addAttribute("searchQuery", searchQuery);
		model.addAttribute("pageNumber", 0);
		return "result";
	}

	@PostMapping("/result/{page}")
	public Object showResultonPage(@RequestParam("searchQuery")String searchQuery,@PathVariable("page")String page,Model model) {
		model.addAttribute("books", books.getBooks(searchQuery,page));
		model.addAttribute("searchQuery", searchQuery);
		model.addAttribute("pageNumber", Integer.valueOf(page));
		return "result";
	}

}
