package com.example.LibraryService.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class LibraryRequest {
    private Integer libraryId;
    private String libraryName;
    private String totalSeat;
    private String ownerName;
    private int totalBooks;
    private int totalMembers;
    private Book book;
    private List<Book> books;
}
