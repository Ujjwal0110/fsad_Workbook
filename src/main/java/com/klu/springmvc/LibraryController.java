package com.klu.springmvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {

    // In-memory book list
    private List<Book> bookList = new ArrayList<>();

    // 2. Welcome message
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the Online Library System!";
    }

    // 3. Total book count
    @GetMapping("/count")
    public int totalBooks() {
        return 120;
    }

    // 4. Sample book price
    @GetMapping("/price")
    public double bookPrice() {
        return 499.99;
    }

    // 5. List of book titles
    @GetMapping("/books")
    public List<String> getBooks() {
        List<String> titles = new ArrayList<>();
        titles.add("Java Programming");
        titles.add("Spring Boot in Action");
        titles.add("Data Structures");
        return titles;
    }

    // 6. Book details using PathVariable
    @GetMapping("/books/{id}")
    public String getBookById(@PathVariable int id) {
        return "Book details for ID: " + id;
    }

    // 7. Search book using RequestParam
    @GetMapping("/search")
    public String searchBook(@RequestParam String title) {
        return "Searching for book with title: " + title;
    }

    // 8. Author name using PathVariable
    @GetMapping("/author/{name}")
    public String author(@PathVariable String name) {
        return "Books written by author: " + name;
    }

    // 9. Add book using POST
    @PostMapping("/addbook")
    public String addBook(@RequestBody Book book) {
        bookList.add(book);
        return "Book added successfully!";
    }

    // 10. View all added books
    @GetMapping("/viewbooks")
    public List<Book> viewBooks() {
        return bookList;
    }
}
