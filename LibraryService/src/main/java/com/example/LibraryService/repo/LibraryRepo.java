package com.example.LibraryService.repo;

import com.example.LibraryService.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepo extends JpaRepository<Library, Integer> {
    Library findByName(String libraryName);
}
