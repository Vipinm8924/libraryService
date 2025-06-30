package com.example.LibraryService.service.impl;

import com.example.LibraryService.entity.Library;
import com.example.LibraryService.repo.LibraryRepo;
import com.example.LibraryService.service.interfaceService.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    LibraryRepo libraryRepository;

    @Override
    public Library getLibraryByLibraryId(int libraryId) {
        Library library = libraryRepository.findByLibraryId(libraryId);
        return library;
    }

    @Override
    public Library getLibraryByLibraryName(String libraryName) {
        Library library = libraryRepository.findByLibraryName(libraryName);
        return library;
    }

    @Override
    public Library saveLibrary(Library library) {
        Library saved = libraryRepository.save(library);
        return saved;
    }

    @Override
    public Library updateLibrary(Library library) {
        Library updated = libraryRepository.save(library);
        return updated;
    }

    @Override
    public void deleteLibraryByLibraryId(int libraryId) {
        libraryRepository.deleteByLibraryId(libraryId);
    }

    @Override
    public void deleteLibraryByLibraryName(String libraryName) {
        libraryRepository.deleteByLibraryName(libraryName);

    }
}
