package com.example.LibraryService.service.interfaceService;

import com.example.LibraryService.dtos.LibraryRequest;
import com.example.LibraryService.dtos.LibraryResponse;

public interface LibraryResponseService {

    LibraryResponse getLibraryByLibraryId(int libraryId);

    LibraryResponse getLibraryByLibraryName(String libraryName);

    LibraryResponse saveLibrary(LibraryRequest libraryRequest);

    LibraryResponse updateLibrary(LibraryRequest libraryRequest);

    void deleteLibraryByLibraryId(int libraryId);

    void deleteLibraryByLibraryName(String libraryName);
}
