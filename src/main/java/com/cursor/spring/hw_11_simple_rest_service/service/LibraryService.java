package com.cursor.spring.hw_11_simple_rest_service.service;

import com.cursor.spring.hw_11_simple_rest_service.entity.Author;
import com.cursor.spring.hw_11_simple_rest_service.entity.Book;

import java.util.List;

public interface LibraryService {

    List<Author> addAuthor(Author author);

    List<Author> deleteAuthor(int id);

    void addAuthorBook(int authorId, Book book);

    List<Book> addBook(Book book);

    List<Book> deleteBook(int id);

    List<Book> getBooksByGenre(String genre);

    List<Book> getBooksByAuthor(int authorId);

    List<Book> updateBook(int oldBookId,Book book);

    List<Author> updateAuthor(int oldAuthorId, Author author);
}
