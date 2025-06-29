package com.example.LibraryService.dtos;

import lombok.Data;

@Data
public class BookResponse {
    private Integer bookId;
    private String bookName;
    private String authorName;
    private String publicationName;
    private String price;
}
