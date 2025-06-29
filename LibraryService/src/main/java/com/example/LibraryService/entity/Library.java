package com.example.LibraryService.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "library")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String totalSeat;
    private String ownerName;
    private int totalBooks;
    private int totalMembers;
}
