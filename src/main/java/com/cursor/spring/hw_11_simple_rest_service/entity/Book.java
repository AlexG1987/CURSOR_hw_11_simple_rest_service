package com.cursor.spring.hw_11_simple_rest_service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    private String title;
    private String genre;
    private String description;
    private double rate;
}
