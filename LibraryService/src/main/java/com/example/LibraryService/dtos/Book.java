package com.example.LibraryService.dtos;

import lombok.Data;

@Data
public class Book {
    private Integer id;
    private String bookName;
    private String authorName;
    private String publicationName;
    private String price;
}
