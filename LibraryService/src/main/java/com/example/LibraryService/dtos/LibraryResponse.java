package com.example.LibraryService.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class LibraryResponse {
    private Integer libraryId;
    private String libraryName;
    private String totalSeat;
    private String ownerName;
    private int totalBooks;
    private int totalMembers;
    private List<BookResponse> books;
}
