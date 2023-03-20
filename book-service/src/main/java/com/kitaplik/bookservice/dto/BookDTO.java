package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;

public class BookDTO {

    private Long id;
    private String title;
    private int bookYear;
    private String author;
    private String pressName;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.bookYear = book.getBookYear();
        this.author = book.getAuthor();
        this.pressName = book.getPressName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBookYear() {
        return bookYear;
    }

    public void setBookYear(int bookYear) {
        this.bookYear = bookYear;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPressName() {
        return pressName;
    }

    public void setPressName(String pressName) {
        this.pressName = pressName;
    }
}
