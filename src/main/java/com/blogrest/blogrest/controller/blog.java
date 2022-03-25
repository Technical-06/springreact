package com.blogrest.blogrest.controller;

public class blog{
	private String title;
    private String text;
    private String author;

    public blog(String title, String text, String author){
        this.title = title;
        this.text = text;
        this.author = author;
    }

    public void setBody(String text) {
        this.text = text;
    }

    public String getBody() {
        return text;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
}

