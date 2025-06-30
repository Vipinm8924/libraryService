package com.example.LibraryService.service.interfaceService;

import com.example.LibraryService.dtos.BookRequest;
import com.example.LibraryService.dtos.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    BookResponse getBookByBookId(int bookId);

    BookResponse getBookByBookName(String bookName);

    BookResponse saveBook(
            Integer libraryId, String libraryName,
            BookRequest bookRequest);

    BookResponse updateBook(
            Integer libraryId, String libraryName,
            BookRequest bookRequest);

    void deleteBookByBookId(int bookId);

    void deleteBookByBookName(String bookName);

    List<BookResponse> getBookListByLibraryId(int libraryId);

    List<BookResponse> getBookListByLibraryName(String libraryName);

    List<BookResponse> saveBookList(
            Integer libraryId, String libraryName,
            List<BookRequest> bookRequestList);

    List<BookResponse> updateBookList(
            Integer libraryId, String libraryName,
            List<BookRequest> bookRequestList);

    void deleteBookListByLibraryId(int libraryId);

    void deleteBookListByLibraryName(String libraryName);


}
