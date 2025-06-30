package com.example.LibraryService.service.impl;

import com.example.LibraryService.dtos.BookResponse;
import com.example.LibraryService.dtos.LibraryRequest;
import com.example.LibraryService.dtos.LibraryResponse;
import com.example.LibraryService.entity.Library;
import com.example.LibraryService.service.interfaceService.BookService;
import com.example.LibraryService.service.interfaceService.LibraryResponseService;
import com.example.LibraryService.service.interfaceService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryResponseServiceImpl implements LibraryResponseService {

    @Autowired
    LibraryService libraryService;
    @Autowired
    BookService bookService;

    @Override
    public LibraryResponse getLibraryByLibraryId(int libraryId) {
        Library library = libraryService.getLibraryByLibraryId(libraryId);
        List<BookResponse> bookResponseList = bookService.getBookListByLibraryId(libraryId);
        LibraryResponse libraryResponse = LibraryResponse.builder()
                .books(bookResponseList)
                .libraryId(library.getLibraryId())
                .libraryName(library.getLibraryName())
                .totalMembers(library.getTotalMembers())
                .ownerName(library.getOwnerName())
                .totalSeat(library.getTotalSeat())
                .totalBooks(library.getTotalBooks())
                .build();
        return libraryResponse;
    }

    @Override
    public LibraryResponse getLibraryByLibraryName(String libraryName) {
        Library library = libraryService.getLibraryByLibraryName(libraryName);
        List<BookResponse> bookResponseList = bookService.getBookListByLibraryName(libraryName);
        LibraryResponse libraryResponse = LibraryResponse.builder()
                .books(bookResponseList)
                .libraryId(library.getLibraryId())
                .libraryName(library.getLibraryName())
                .totalMembers(library.getTotalMembers())
                .ownerName(library.getOwnerName())
                .totalSeat(library.getTotalSeat())
                .totalBooks(library.getTotalBooks())
                .build();
        return libraryResponse;
    }

    @Override
    public LibraryResponse saveLibrary(LibraryRequest libraryRequest) {
        Library library = Library.builder()
                .libraryId(libraryRequest.getLibraryId())
                .libraryName(libraryRequest.getLibraryName())
                .totalSeat(libraryRequest.getTotalSeat())
                .totalMembers(libraryRequest.getTotalMembers())
                .ownerName(libraryRequest.getOwnerName())
                .build();
        Library saved = libraryService.saveLibrary(library);

        List<BookResponse> bookResponseList = bookService.saveBookList(
                libraryRequest.getLibraryId(), libraryRequest.getLibraryName(), libraryRequest.getBooks());

        LibraryResponse libraryResponse = LibraryResponse.builder()
                .books(bookResponseList)
                .libraryId(saved.getLibraryId())
                .libraryName(saved.getLibraryName())
                .totalMembers(saved.getTotalMembers())
                .ownerName(saved.getOwnerName())
                .totalSeat(saved.getTotalSeat())
                .totalBooks(saved.getTotalBooks())
                .build();
        return libraryResponse;
    }

    @Override
    public LibraryResponse updateLibrary(LibraryRequest libraryRequest) {
        Library library = Library.builder()
                .libraryId(libraryRequest.getLibraryId())
                .libraryName(libraryRequest.getLibraryName())
                .totalSeat(libraryRequest.getTotalSeat())
                .totalMembers(libraryRequest.getTotalMembers())
                .ownerName(libraryRequest.getOwnerName())
                .build();
        Library updated = libraryService.updateLibrary(library);
        List<BookResponse> bookResponseList = bookService.updateBookList(
                libraryRequest.getLibraryId(), libraryRequest.getLibraryName(), libraryRequest.getBooks());

        LibraryResponse libraryResponse = LibraryResponse.builder()
                .books(bookResponseList)
                .libraryId(updated.getLibraryId())
                .libraryName(updated.getLibraryName())
                .totalMembers(updated.getTotalMembers())
                .ownerName(updated.getOwnerName())
                .totalSeat(updated.getTotalSeat())
                .totalBooks(updated.getTotalBooks())
                .build();
        return libraryResponse;
    }

    @Override
    public void deleteLibraryByLibraryId(int libraryId) {
        libraryService.deleteLibraryByLibraryId(libraryId);
        bookService.deleteBookListByLibraryId(libraryId);
    }

    @Override
    public void deleteLibraryByLibraryName(String libraryName) {
        libraryService.deleteLibraryByLibraryName(libraryName);
        bookService.deleteBookListByLibraryName(libraryName);

    }
}
