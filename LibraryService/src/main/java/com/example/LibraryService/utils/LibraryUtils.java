package com.example.LibraryService.utils;

import com.example.LibraryService.dtos.BookResponse;
import com.example.LibraryService.dtos.LibraryResponse;
import com.example.LibraryService.entity.Library;

import java.util.List;

public class LibraryUtils {

    public static LibraryResponse buildLibraryResponseWithBook(Library library, BookResponse bookResponse) {
        LibraryResponse libraryResponse = LibraryResponse.builder()
                .libraryId(library.getLibraryId())
                .libraryName(library.getLibraryName())
                .ownerName(library.getOwnerName())
                .totalBooks(library.getTotalBooks())
                .totalMembers(library.getTotalMembers())
                .totalSeat(library.getTotalSeat())
                .build();
        return libraryResponse;
    }

    public static LibraryResponse buildLibraryResponseWithBookList(Library library, List<BookResponse> books) {
        LibraryResponse libraryResponse = LibraryResponse.builder()
                .libraryId(library.getId())
                .books(books)
                .libraryName(library.getLibraryName())
                .ownerName(library.getOwnerName())
                .totalBooks(library.getTotalBooks())
                .totalMembers(library.getTotalMembers())
                .totalSeat(library.getTotalSeat())
                .build();
        return libraryResponse;
    }
}
