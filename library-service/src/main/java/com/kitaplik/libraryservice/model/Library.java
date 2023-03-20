package com.kitaplik.libraryservice.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ElementCollection
    List<Long> bookList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getBookList() {
        return bookList;
    }

    public void setBookList(List<Long> bookList) {
        this.bookList = bookList;
    }
}
