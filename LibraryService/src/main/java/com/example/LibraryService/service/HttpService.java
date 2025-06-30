package com.example.LibraryService.service;

import com.example.LibraryService.dtos.BookRequest;
import com.example.LibraryService.dtos.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class HttpService {

    public static String baseUrl = "http://localhost:8081/psit/";


    @Autowired
    RestTemplate restTemplate;

    public BookResponse getBookByBookIdHttp(int bookId) {
        String apiPath = "/book/fetchByBookId/{bookId}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<BookResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                BookResponse.class,
                bookId
        );

        BookResponse bookResponse = response.getBody();
        return bookResponse;
    }

    public BookResponse getBookByBookNameHttp(String bookName) {
        String apiPath = "/book/fetchByBookName/{bookName}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<BookResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                BookResponse.class,
                bookName
        );
        BookResponse bookResponse = response.getBody();
        return bookResponse;
    }

    public BookResponse saveBookHttp(
            Integer libraryId, String libraryName,
            BookRequest bookRequest) {
        String apiPath = "/book/save";
        String apiUrl = baseUrl + apiPath + "?libraryId=" + libraryId + "&libraryName=" + libraryName;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BookRequest> requestEntity = new HttpEntity<>(bookRequest, headers);
        ResponseEntity<BookResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                BookResponse.class
        );

        BookResponse bookResponse = response.getBody();
        return bookResponse;
    }

    public BookResponse updateBookHttp(
            Integer libraryId, String libraryName,
            BookRequest bookRequest) {
        String apiPath = "/book/update";
        String apiUrl = baseUrl + apiPath + "?libraryId=" + libraryId + "&libraryName=" + libraryName;


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<BookRequest> requestEntity = new HttpEntity<>(bookRequest, headers);
        ResponseEntity<BookResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.PUT,
                requestEntity,
                BookResponse.class
        );
        BookResponse bookResponse = response.getBody();
        return bookResponse;
    }

    public void deleteBookByBookIdHttp(int bookId) {
        String apiPath = "/book/deleteByBookId/{bookId}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<Void> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.DELETE,
                null,
                Void.class,
                bookId
        );
        System.out.println("Response Status  " + response.getStatusCode());
    }

    public void deleteBookByBookNameHttp(String bookName) {
        String apiPath = "/book/deleteByBookName/{bookName}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<Void> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.DELETE,
                null,
                Void.class,
                bookName
        );
        System.out.println("Response Status  " + response.getStatusCode());
    }

    public List<BookResponse> getBookListByLibraryIdHttp(int libraryId) {
        String apiPath = "/bookList/fetchByLibraryId/{libraryId}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<List<BookResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BookResponse>>() {
                },
                libraryId
        );

        List<BookResponse> bookResponse = response.getBody();
        return bookResponse;
    }

    public List<BookResponse> getBookListByLibraryNameHttp(String libraryName) {
        String apiPath = "/bookList/fetchByLibraryName/{libraryName}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<List<BookResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<BookResponse>>() {
                },
                libraryName
        );

        List<BookResponse> bookResponse = response.getBody();
        return bookResponse;
    }

    public List<BookResponse> saveBookListHttp(
            int libraryId, String libraryName,
            List<BookRequest> bookRequestList) {
        String apiPath = "/bookList/save";
        String apiUrl = baseUrl + apiPath + "?libraryId=" + libraryId + "&libraryName=" + libraryName;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<BookRequest>> requestEntity = new HttpEntity<>(bookRequestList, headers);
        ResponseEntity<List<BookResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<BookResponse>>() {
                }
        );
        return response.getBody();
    }

    public List<BookResponse> updateBookListHttp(
            Integer libraryId, String libraryName,
            List<BookRequest> bookRequestList) {
        String apiPath = "/bookList/update";
        String apiUrl = baseUrl + apiPath + "?libraryId=" + libraryId + "&libraryName=" + libraryName;


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<List<BookRequest>> requestEntity = new HttpEntity<>(bookRequestList, headers);
        ResponseEntity<List<BookResponse>> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.PUT,
                requestEntity,
                new ParameterizedTypeReference<List<BookResponse>>() {
                }
        );

        List<BookResponse> bookResponse = response.getBody();
        return bookResponse;
    }

    public void deleteBookListByLibraryIdHttp(int libraryId) {
        String apiPath = "/bookList/deleteByLibraryId/{libraryId}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<Void> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.DELETE,
                null,
                Void.class,
                libraryId
        );
        System.out.println("Response Status  " + response.getStatusCode());
    }


    public void deleteBookListByLibraryNameHttp(String libraryName) {
        String apiPath = "/bookList/deleteByLibraryName/{libraryName}";
        String apiUrl = baseUrl + apiPath;
        ResponseEntity<Void> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.DELETE,
                null,
                Void.class,
                libraryName
        );
        System.out.println("Response Status  " + response.getStatusCode());
    }
}
