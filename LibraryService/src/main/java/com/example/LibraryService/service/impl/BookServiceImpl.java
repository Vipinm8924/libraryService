package com.example.LibraryService.service.impl;

import com.example.LibraryService.dtos.BookRequest;
import com.example.LibraryService.dtos.BookResponse;
import com.example.LibraryService.service.HttpService;
import com.example.LibraryService.service.interfaceService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public BookResponse saveBook(
            Integer libraryId, String libraryName,
            BookRequest bookRequest) {
        BookResponse bookResponse = httpService.saveBookHttp(
                libraryId, libraryName, bookRequest);
        return bookResponse;
    }

    @Override
    public BookResponse updateBook(
            Integer libraryId, String libraryName,
            BookRequest bookRequest) {
        BookResponse bookResponse = httpService.updateBookHttp(
                libraryId, libraryName, bookRequest);
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
    public List<BookResponse> saveBookList(
            Integer libraryId, String libraryName,
            List<BookRequest> bookRequestList) {
        List<BookResponse> bookResponseList = httpService.saveBookListHttp(
                libraryId, libraryName, bookRequestList);
        return bookResponseList;
    }

    @Override
    public List<BookResponse> updateBookList(
            Integer libraryId, String libraryName,
            List<BookRequest> bookRequestList) {
        List<BookResponse> bookResponseList = httpService.updateBookListHttp(
                libraryId, libraryName, bookRequestList);
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
