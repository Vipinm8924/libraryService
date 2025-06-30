package com.example.LibraryService.service.interfaceService;

import com.example.LibraryService.entity.Library;
import org.springframework.stereotype.Service;

@Service
public interface LibraryService {

    Library getLibraryByLibraryId(int libraryId);

    Library getLibraryByLibraryName(String libraryName);

    Library saveLibrary(Library library);

    Library updateLibrary(Library library);

    void deleteLibraryByLibraryId(int id);

    void deleteLibraryByLibraryName(String name);

}
