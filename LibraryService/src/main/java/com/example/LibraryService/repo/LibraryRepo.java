package com.example.LibraryService.repo;

import com.example.LibraryService.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Integer> {
    Library findByLibraryId(int libraryId);

    Library findByLibraryName(String libraryName);

    void deleteByLibraryId(int libraryId);

    void deleteByLibraryName(String libraryName);
}
