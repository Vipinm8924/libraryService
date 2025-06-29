package com.example.LibraryService.service.interfaceService;

import com.example.LibraryService.dtos.BookRequest;
import com.example.LibraryService.dtos.BookResponse;

import java.util.List;

public interface BookService {

    BookResponse getBookByBookId(int bookId);

    BookResponse getBookByBookName(String bookName);

    BookResponse saveBook(BookRequest bookRequest);

    BookResponse updateBook(BookRequest bookRequest);

    void deleteBookByBookId(int bookId);

    void deleteBookByBookName(String bookName);

    List<BookResponse> getBookListByLibraryId(int libraryId);

    List<BookResponse> getBookListByLibraryName(String libraryName);

    List<BookResponse> saveBookList(List<BookRequest> bookRequestList);

    List<BookResponse> updateBookList(List<BookRequest> bookRequestList);

    void deleteBookListByLibraryId(int libraryId);

    void deleteBookListByLibraryName(String libraryName);


}
