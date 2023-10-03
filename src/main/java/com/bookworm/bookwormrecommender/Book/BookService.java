package com.bookworm.bookwormrecommender.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDTO getBookDetails(Long bookId) {
        // Implement logic to retrieve and map book details to a BookDTO
        // Retrieve the book by ID from the database
        Book book = bookRepository.findById(bookId).orElse(null);

        if (book != null) {
            // Map book details to a BookDTO
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setDescription(book.getDescription());
            bookDTO.setPublicationYear(book.getPublicationYear());
            bookDTO.setAuthorName(book.getAuthor().getName());
            bookDTO.setGenreName(book.getGenre().getName());

            return bookDTO;
        } else {
            // Book not found
            return null;
        }
    }

    // Add more methods for book-related operations, such as retrieving recommendations and submitting reviews
}

