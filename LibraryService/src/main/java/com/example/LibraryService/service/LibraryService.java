package com.example.LibraryService.service;

import com.example.LibraryService.dtos.LibraryResponse;
import com.example.LibraryService.dtos.Book;
import com.example.LibraryService.entity.Library;
import com.example.LibraryService.repo.LibraryRepo;
import com.example.LibraryService.utils.LibraryUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LibraryRepo libraryRepo;

    public Library getLibraryByID(int id) {
        return libraryRepo.findById(id).get();
    }

    public Library insert(Library library) {
        return libraryRepo.save(library);
    }

    public LibraryResponse getLibraryResponse(int id) {
        Book book = restTemplate.getForObject("http://localhost:8081/psit/book/" + id, Book.class);
        Library library = getLibraryByID(id);
        LibraryResponse libraryResponse = LibraryUtils.buildLibraryResponseWithBook(library, book);
        return libraryResponse;
    }


    public LibraryResponse getLibraryResponseById(int libraryId) {
        List<Book> books = restTemplate.getForObject("http://localhost:8081/psit/books/byLibraryId/" + libraryId, List.class);
        Library library = getLibraryByLibraryId(libraryId);
        LibraryResponse libraryResponse = LibraryUtils.buildLibraryResponseWithBookList(library, books);
        return libraryResponse;
    }

    private Library getLibraryByLibraryId(int libraryId) {
        Optional<Library> libraryOptional = libraryRepo.findById(libraryId);
        if(libraryOptional.isEmpty()) {
            System.out.println("Library Not Found!");
        }
        return libraryOptional.get();
    }

    public LibraryResponse getLibraryResponseByName(String libraryName) {
        List<Book> books = restTemplate.getForObject("http://localhost:8081/psit/books/byLibraryName/" + libraryName, List.class);
        Library library = getLibraryByLibraryName(libraryName);
        LibraryResponse libraryResponse = LibraryUtils.buildLibraryResponseWithBookList(library, books);
        return libraryResponse;
    }

    private Library getLibraryByLibraryName(String libraryName) {
        return libraryRepo.findByName(libraryName);
    }
}
