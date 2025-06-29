package com.example.LibraryService.controller;

import com.example.LibraryService.dtos.LibraryResponse;
import com.example.LibraryService.entity.Library;
import com.example.LibraryService.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psit")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("libraryById/{id}")
    public LibraryResponse getLibraryById(@PathVariable int id) {
        System.out.println(id);
        LibraryResponse libraryResponse = libraryService.getLibraryResponseById(id);
        return libraryResponse;
    }

    @GetMapping("libraryByName/{name}")
    public LibraryResponse getLibraryByName(@PathVariable String name) {
        System.out.println(name);
        LibraryResponse libraryResponse = libraryService.getLibraryResponseByName(name);
        return libraryResponse;
    }


    @PostMapping("/insert")
    public Library insertLibrary(@RequestBody Library library) {
        return libraryService.insert(library);
    }
}
