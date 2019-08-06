package com.cursor.spring.hw_11_simple_rest_service.service;

import com.cursor.spring.hw_11_simple_rest_service.entity.Author;
import com.cursor.spring.hw_11_simple_rest_service.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final List<Author> authorList = new ArrayList<>(Arrays.asList(
            new Author(1, "Joshua", "Bloch"),
            new Author(2, "John", "Tolkien"),
            new Author(3, "Ayn", "Rand")
    ));
    private final List<Book> bookList = new ArrayList<>(Arrays.asList(
            new Book(1, "Effective Java", "Educational", "Table book for Java programmers", 9.0),
            new Book(2, "The Lord of the Rings", "Fantasy", "Very interesting story about hobbit Frodo Torbyn and his friends", 9.2),
            new Book(3, "Atlas Shrugged", "Novel", "Story of the struggle of business with the state, the relationship between people", 8.8)
    ));

    @Override
    public List<Author> addAuthor(Author author) {
        authorList.add(author);
        return authorList;
    }

    @Override
    public List<Author> deleteAuthor(int id) {
        authorList.removeIf(author -> author.getId() == id);
        return authorList;
    }

    @Override
    public void addAuthorBook(int authorId, Book book) {
        authorList.stream()
                .filter(a -> a.getId() == authorId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Item not found"))
                .setBooks(book);
    }

    @Override
    public List<Book> addBook(Book book) {
        bookList.add(book);
        return bookList;
    }

    @Override
    public List<Book> deleteBook(int id) {
        bookList.removeIf(book -> book.getId() == id);
        return bookList;
    }

    @Override
    public List<Book> getBooksByGenre(String genre) {
        return bookList.stream()
                .filter(book -> book.getGenre().equals(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getBooksByAuthor(int authorId) {
        return authorList.stream()
                .filter(author -> author.getId() == authorId)
                .flatMap(author -> author.getBooks().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> updateBook(int oldBookId, Book newBook) {
        bookList.removeIf(book -> book.getId() == oldBookId);
        bookList.add(newBook);
        return bookList;
    }

    @Override
    public List<Author> updateAuthor(int oldAuthorId, Author newAuthor) {
        authorList.removeIf(author -> author.getId() == oldAuthorId);
        authorList.add(newAuthor);
        return authorList;
    }
}
