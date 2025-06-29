package com.example.LibraryService.dtos;

import lombok.Data;

@Data
public class BookRequest {
    private Integer bookId;
    private String bookName;
    private String authorName;
    private String publicationName;
    private String price;
}
