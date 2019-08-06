package com.cursor.spring.hw_11_simple_rest_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    private int id;
    private String fName;
    private String lName;
    List<Book> books = new ArrayList<>();

    public Author(int id, String fName, String lName) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
    }

    public void setBooks(Book book) {
        books.add(book);
    }
}
