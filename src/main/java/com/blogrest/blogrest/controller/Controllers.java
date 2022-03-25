package com.blogrest.blogrest.controller;

import java.util.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class Controllers {
	 ArrayList<blog> blogs = new ArrayList<>();

	    void populateBlogs() {
	        blogs.add(new blog("Quantiphi", "Quantiphi is an award-winning applied AI and data science software and services company driven by the desire to solve transformational problems at the heart", "Sonal Bedi"));
	        blogs.add(new blog("Meditation","A good introduction to meditation for beginners is the “body scan” technique, which is actually a great way to cultivate the gentle curiosity we need to bring to a meditation.","Nikhil Bedi"));
	    }

	    Controllers(){
	        populateBlogs();
	    }

	    @GetMapping("/ViewArticle")
	    public ArrayList<blog> getAllBlogs() {
	        return blogs;
	    }

	}

