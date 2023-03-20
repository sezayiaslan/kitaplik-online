package com.kitaplik.bookservice.dto;

import com.kitaplik.bookservice.model.Book;

public class BookIdDTO {

    private Long id;
    private String isbn;

    public BookIdDTO(Book book){
        this.id = book.getId();
        this.isbn = book.getIsbn();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
