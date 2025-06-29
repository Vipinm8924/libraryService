package com.example.LibraryService.utils;

import com.example.LibraryService.dtos.LibraryResponse;
import com.example.LibraryService.dtos.Book;
import com.example.LibraryService.entity.Library;

import java.util.List;

public class LibraryUtils {

    public static LibraryResponse buildLibraryResponseWithBook(Library library, Book book) {
        LibraryResponse libraryResponse = LibraryResponse.builder()
                .libraryId(library.getId())
                .book(book)
                .libraryName(library.getName())
                .ownerName(library.getOwnerName())
                .totalBooks(library.getTotalBooks())
                .totalMembers(library.getTotalMembers())
                .totalSeat(library.getTotalSeat())
                .build();
        return libraryResponse;
    }

    public static LibraryResponse buildLibraryResponseWithBookList(Library library, List<Book> books) {
        LibraryResponse libraryResponse = LibraryResponse.builder()
                .libraryId(library.getId())
                .books(books)
                .libraryName(library.getName())
                .ownerName(library.getOwnerName())
                .totalBooks(library.getTotalBooks())
                .totalMembers(library.getTotalMembers())
                .totalSeat(library.getTotalSeat())
                .build();
        return libraryResponse;
    }


    public static LibraryResponse buildLibraryResponse(Library library, Book book) {
        return null;
    }
}
