package com.hardik.bookrepository.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping({"/","/index","/home"})
	public String showIndex() {
		return "index";
	}
	

}
