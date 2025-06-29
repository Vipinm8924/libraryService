package com.example.LibraryService.controller;

import com.example.LibraryService.dtos.LibraryRequest;
import com.example.LibraryService.dtos.LibraryResponse;
import com.example.LibraryService.service.interfaceService.LibraryResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/psit")
public class LibraryController {

    @Autowired
    private LibraryResponseService libraryResponseService;

    @GetMapping("/library/fetch/byLibraryId/{libraryId}")
    public ResponseEntity<LibraryResponse> getLibraryByLibraryId(@PathVariable int libraryId) {
        try {
            LibraryResponse libraryResponse = libraryResponseService.getLibraryByLibraryId(libraryId);
            System.out.println("Successfully fetched by libraryId " + libraryId);
            return ResponseEntity.ok(libraryResponse);
        } catch (Exception exception) {
            System.out.println("Exception Msg: " + exception.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/library/fetch/byLibraryName/{libraryName}")
    public ResponseEntity<LibraryResponse> getLibraryByLibraryName(@PathVariable String libraryName) {
        try {
            LibraryResponse libraryResponse = libraryResponseService.getLibraryByLibraryName(libraryName);
            System.out.println("Successfully fetched by libraryName " + libraryName);
            return new ResponseEntity<>(libraryResponse, HttpStatus.OK);

        } catch (Exception ex) {
            System.out.println("Exception msg " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/library/save")
    public ResponseEntity<LibraryResponse> saveLibrary(@RequestBody LibraryRequest libraryRequest) {
        try {
            LibraryResponse libraryResponse = libraryResponseService.saveLibrary(libraryRequest);
            System.out.println("Successfully saved");
            return new ResponseEntity<>(libraryResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Exception msg " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/library/update")
    public ResponseEntity<LibraryResponse> updateLibrary(@RequestBody LibraryRequest libraryRequest) {
        try {
            LibraryResponse libraryResponse = libraryResponseService.updateLibrary(libraryRequest);
            System.out.println("Successfully updated");
            return new ResponseEntity<>(libraryResponse, HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println("Exception msg " + ex.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/library/delete/byLibraryId/{libraryId}")
    public ResponseEntity<String> deleteLibraryByLibraryId(@PathVariable int libraryId) {
        try {
            libraryResponseService.deleteLibraryByLibraryId(libraryId);
            System.out.println("Successfully deleted by libraryId " + libraryId);
            return new ResponseEntity<>("successfully deleted by libraryId ", HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println(" Exception exception " + exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/library/delete/byLibraryName/{libraryName}")
    public ResponseEntity<String> deleteLibraryByLibraryName(@PathVariable String libraryName) {
        try {
            libraryResponseService.deleteLibraryByLibraryName(libraryName);
            System.out.println("Successfully deleted by libraryName " + libraryName);
            return new ResponseEntity<>("Successfully Deleted By LibraryName ", HttpStatus.OK);
        } catch (Exception exception) {
            System.out.println("Exception exception " + exception.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
