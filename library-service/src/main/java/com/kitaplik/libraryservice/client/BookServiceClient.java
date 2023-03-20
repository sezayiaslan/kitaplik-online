package com.kitaplik.libraryservice.client;

import com.kitaplik.libraryservice.dto.BookDTO;
import com.kitaplik.libraryservice.dto.BookIdDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service",path = "/v1/book")
public interface BookServiceClient {

    @GetMapping("/isbn/{isbn}")
    ResponseEntity<BookIdDTO> getBookByIsbn(@PathVariable String isbn);

    @GetMapping("/book/{id}")
    ResponseEntity<BookDTO> getBookById(@PathVariable Long id);
}
