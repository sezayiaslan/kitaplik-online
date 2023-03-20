package com.kitaplik.libraryservice.dto;

import java.util.ArrayList;
import java.util.List;

public class LibraryDTO {

    private Long id;
    private List<BookDTO> bookList = new ArrayList<>();

    public LibraryDTO(Long id) {
        this.id = id;
    }

    public LibraryDTO(Long id, List<BookDTO> bookList) {
        this.id = id;
        this.bookList = bookList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<BookDTO> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDTO> bookList) {
        this.bookList = bookList;
    }
}
