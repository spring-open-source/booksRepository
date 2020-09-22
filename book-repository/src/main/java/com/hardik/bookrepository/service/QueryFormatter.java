package com.hardik.bookrepository.service;

import org.springframework.stereotype.Service;

@Service
public class QueryFormatter {
	
	public String format(String searchQuery) {
		return searchQuery.trim().replace(" ","+");
	}

}
