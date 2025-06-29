package com.example.LibraryService.service;

import com.example.LibraryService.dtos.LibraryResponse;

public interface ILibraryResponseService {

    public LibraryResponse getLibraryResponseByLibraryId(int libraryId);

    public LibraryResponse getLibraryResponseByLibraryName(String libraryName);

    public LibraryResponse saveLibraryResponse(LibraryResponse libraryResponse);
}
