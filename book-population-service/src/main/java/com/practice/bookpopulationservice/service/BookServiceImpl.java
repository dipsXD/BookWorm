package com.practice.bookpopulationservice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.practice.bookpopulationservice.model.BookInfo;
import com.practice.bookpopulationservice.model.GoogleBooksApiResponse;
import com.practice.bookpopulationservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{

    @Autowired
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;
    private final BookRepository bookRepository;

    @Value("${google.books.api.url}")
    private String googleBooksApiUrl;

    @Value("${google.books.api.key}")
    private String googleBooksApiKey;

//    public BookServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper, BookRepository bookRepository) {
//        this.restTemplate = restTemplate;
//        this.objectMapper = objectMapper;
//        this.bookRepository = bookRepository;
//    }


    public List<BookInfo> getBookInfo(String isbn) {
        // Build the URL for the Google Books API request
        String apiUrl = String.format("%s/volumes?q=isbn:%s&key=%s", googleBooksApiUrl, isbn, googleBooksApiKey);

        // Make a GET request to the Google Books API
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        // Check if the request was successful (HTTP 200 OK)
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            try {
                // Deserialize the JSON response into BookInfo objects
                GoogleBooksApiResponse apiResponse = objectMapper.readValue(responseEntity.getBody(), GoogleBooksApiResponse.class);

                // Extract relevant information
                if (apiResponse.getItems() != null && !apiResponse.getItems().isEmpty()) {
                    List<BookInfo> bookInfoList = apiResponse.getItems().stream()
                            .map(item -> new BookInfo(
                                    item.getVolumeInfo().getTitle(),
                                    item.getVolumeInfo().getAuthors(),
                                    item.getVolumeInfo().getPublishedDate()))
                            .collect(Collectors.toList());

                    // Save to MongoDB
                    bookRepository.saveAll(bookInfoList);

                    return bookInfoList;
                }
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception according to your application's error handling strategy
            }
        }

        // Return an empty list or throw an exception if something goes wrong
        return Collections.emptyList();
    }

}
