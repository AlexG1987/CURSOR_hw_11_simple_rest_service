package com.cursor.spring.hw_11_simple_rest_service.controller;

import com.cursor.spring.hw_11_simple_rest_service.entity.Author;
import com.cursor.spring.hw_11_simple_rest_service.entity.Book;
import com.cursor.spring.hw_11_simple_rest_service.service.LibraryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/library")
@AllArgsConstructor
public class LibraryController {

    @Autowired
    final LibraryServiceImpl LibraryServiceImpl;

    @PostMapping("/addAuthor")
    public List<Author> addAuthor(@RequestBody Author author) {
        return LibraryServiceImpl.addAuthor(author);
    }

    @PostMapping("/addBook")
    public List<Book> addBook(@RequestBody Book book) {
        return LibraryServiceImpl.addBook(book);
    }

    @PutMapping("/addBookToAuthor")
    public Map<Integer, Book> addBookToAuthor(@RequestBody Book book1, int authorId) {
        Map<Integer, Book> map = new LinkedHashMap<>();
        LibraryServiceImpl.addAuthorBook(authorId, book1);
        map.put(authorId, book1);
        return map;
    }

    @GetMapping("/sortedBooksByAuthor/{id}")
    public List<Book> sortedBooksByAuthor(@PathVariable("id") int id) {
        return LibraryServiceImpl.getBooksByAuthor(id);
    }

    @ResponseBody
    @GetMapping("/sortedBooksByGenre/{genre}")
    public List<Book> sortedBooksByGenre(@PathVariable("genre") String genre) {
        return LibraryServiceImpl.getBooksByGenre(genre);
    }

    @DeleteMapping("/deleteAuthor/{id}")
    public List<Author> deleteAuthor(@PathVariable("id") int authorId) {
        return LibraryServiceImpl.deleteAuthor(authorId);
    }

    @DeleteMapping("/deleteBook/{id}")
    public List<Book> deleteBook(@PathVariable("id") int bookId) {
        return LibraryServiceImpl.deleteBook(bookId);
    }

    @PatchMapping("updateAuthor/{id}")
    public List<Author> updateAuthor(@PathVariable("id") int oldAuthorId, @RequestBody Author author) {
        return LibraryServiceImpl.updateAuthor(oldAuthorId, author);
    }

    @PatchMapping("updateBook/{id}")
    public List<Book> updateBook(@PathVariable("id") int oldBookId, @RequestBody Book book) {
        return LibraryServiceImpl.updateBook(oldBookId, book);
    }

}
