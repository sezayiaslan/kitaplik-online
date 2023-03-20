package com.kitaplik.libraryservice.service;

import com.kitaplik.libraryservice.client.BookServiceClient;
import com.kitaplik.libraryservice.dto.AddBookRequestDTO;
import com.kitaplik.libraryservice.dto.LibraryDTO;
import com.kitaplik.libraryservice.exception.LibraryNotFoundException;
import com.kitaplik.libraryservice.model.Library;
import com.kitaplik.libraryservice.repository.LibraryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LibraryService {

    private final LibraryRepository libraryRepository;
    private final BookServiceClient bookServiceClient;

    public LibraryService(LibraryRepository libraryRepository, BookServiceClient bookServiceClient) {
        this.libraryRepository = libraryRepository;
        this.bookServiceClient = bookServiceClient;
    }

    public LibraryDTO getAllBooksInLibraryById(Long id){
        Library library = libraryRepository.findById(id)
                .orElseThrow(()->new LibraryNotFoundException("Library could not found"));


        for (Long bookId: library.getBookList()) {
            System.out.println(bookId);
            Long bookResponseEntitydenGelenId = bookServiceClient.getBookById(2L).getBody().getId();
           // Long bookResponseEntitydenGelenId = bookServiceClient.getBookById(bookId).getBody().getId();
            System.out.println(bookResponseEntitydenGelenId);
        }


        LibraryDTO libraryDTO = new LibraryDTO(library.getId(),
                library.getBookList().stream()
                        .map(bookServiceClient::getBookById)
                        .map(ResponseEntity::getBody)
                        .collect(Collectors.toList())
        );

        return libraryDTO;
    }

    public LibraryDTO createLibrary(){
        Library library = libraryRepository.save(new Library());
        return new LibraryDTO(library.getId());
    }

    public void addBookToLibrary(AddBookRequestDTO addBookRequestDTO){
        Long bookId = Objects.requireNonNull(bookServiceClient.getBookByIsbn(addBookRequestDTO.getIsbn()).getBody()).getId();

        Library library = libraryRepository.findById(addBookRequestDTO.getId())
                .orElseThrow(()->new LibraryNotFoundException("Library could not found by id: "+addBookRequestDTO.getId()));

        library.getBookList().add(bookId);
        libraryRepository.save(library);
    }

    public List<Long> getAllLibraries() {
        return libraryRepository.findAll().stream()
                .map(Library::getId)
                .collect(Collectors.toList());
    }
}
