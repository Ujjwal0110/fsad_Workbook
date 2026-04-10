package com.klu.librarymvc.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class LibraryController {

    List<String> books = new ArrayList<>();
    List<Map<String,String>> bookObjects = new ArrayList<>();

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to Online Library System";
    }

    @GetMapping("/count")
    public int count() {
        return 100;
    }

    @GetMapping("/price")
    public double price() {
        return 299.99;
    }

    @GetMapping("/books")
    public List<String> books() {
        return Arrays.asList("Java", "Spring Boot", "Python", "Data Structures");
    }

    @GetMapping("/books/{id}")
    public String bookDetails(@PathVariable int id) {
        return "Details of Book ID: " + id;
    }

    @GetMapping("/search")
    public String search(@RequestParam String title) {
        return "Searching book with title: " + title;
    }

    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    @PostMapping("/addbook")
    public String addBook(@RequestBody Map<String,String> book) {
        bookObjects.add(book);
        return "Book added successfully";
    }

    @GetMapping("/viewbooks")
    public List<Map<String,String>> viewBooks() {
        return bookObjects;
    }
}