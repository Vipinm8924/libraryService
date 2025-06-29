package com.example.LibraryService.service.impl;

import com.example.LibraryService.dtos.BookRequest;
import com.example.LibraryService.dtos.BookResponse;
import com.example.LibraryService.service.HttpService;
import com.example.LibraryService.service.interfaceService.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Autowired
    HttpService httpService;

    @Override
    public BookResponse getBookByBookId(int bookId) {
        BookResponse bookResponse = httpService.getBookByBookIdHttp(bookId);
        return bookResponse;
    }

    @Override
    public BookResponse getBookByBookName(String bookName) {
        BookResponse bookResponse = httpService.getBookByBookNameHttp(bookName);
        return bookResponse;
    }

    @Override
    public BookResponse saveBook(BookRequest bookRequest) {
        BookResponse bookResponse = httpService.saveBookHttp(bookRequest);
        return bookResponse;
    }

    @Override
    public BookResponse updateBook(BookRequest bookRequest) {
        BookResponse bookResponse = httpService.updateBookHttp(bookRequest);
        return bookResponse;
    }

    @Override
    public void deleteBookByBookId(int bookId) {
        httpService.deleteBookByBookIdHttp(bookId);

    }

    @Override
    public void deleteBookByBookName(String bookName) {
        httpService.deleteBookByBookNameHttp(bookName);

    }

    @Override
    public List<BookResponse> getBookListByLibraryId(int libraryId) {
        List<BookResponse> bookResponseList = httpService.getBookListByLibraryIdHttp(libraryId);
        return bookResponseList;
    }

    @Override
    public List<BookResponse> getBookListByLibraryName(String libraryName) {
        List<BookResponse> bookResponseList = httpService.getBookListByLibraryNameHttp(libraryName);
        return bookResponseList;
    }

    @Override
    public List<BookResponse> saveBookList(List<BookRequest> bookRequestList) {
        List<BookResponse> bookResponseList = httpService.saveBookListHttp(bookRequestList);
        return bookResponseList;
    }

    @Override
    public List<BookResponse> updateBookList(List<BookRequest> bookRequestList) {
        List<BookResponse> bookResponseList = httpService.updateBookListHttp(bookRequestList);
        return bookResponseList;
    }

    @Override
    public void deleteBookListByLibraryId(int libraryId) {
        httpService.deleteBookListByLibraryIdHttp(libraryId);

    }

    @Override
    public void deleteBookListByLibraryName(String libraryName) {
        httpService.deleteBookListByLibraryNameHttp(libraryName);
    }
}
