package com.hardik.bookrepository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookService {
	
	private final String apiKey = "..."; 
	
	private RestTemplate restTemplate;
	
	private QueryFormatter queryFormatter;
	
	public BookService() {
		super();
	}

	@Autowired
	public BookService(RestTemplate restTemplate, QueryFormatter queryFormatter) {
		super();
		this.restTemplate = restTemplate;
		this.queryFormatter = queryFormatter;
	}

	private String url = "https://www.googleapis.com/books/v1/volumes?q=QUERY&key=API_KEY&startIndex=START_INDEX&maxResults=4";
	
	public Object getBooks(String searchQuery, String page) {
		return restTemplate.getForObject(((url.replace("API_KEY", apiKey)).replace("QUERY",queryFormatter.format(searchQuery)).replace("START_INDEX", page))
					,Object.class);
	}

}
