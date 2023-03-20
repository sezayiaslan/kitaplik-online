package com.kitaplik.bookservice.service;

import com.kitaplik.bookservice.dto.BookDTO;
import com.kitaplik.bookservice.dto.BookIdDTO;
import com.kitaplik.bookservice.exception.BookNotFoundException;
import com.kitaplik.bookservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks(){
        return bookRepository.findAll()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    public BookIdDTO findByIsbn(String isbn){
        return bookRepository.findBookByIsbn(isbn)
                .map(BookIdDTO::new)
                .orElseThrow(()->new BookNotFoundException("Book could not found by isbn: "+ isbn));
    }

    public BookDTO findBookDetailsById(Long id){
        return bookRepository.findById(id)
                .map(BookDTO::new)
                .orElseThrow(()->new BookNotFoundException("Book could not found by id: "+ id));
    }
}
