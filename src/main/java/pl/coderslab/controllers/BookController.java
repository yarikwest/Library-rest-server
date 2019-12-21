package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entities.Book;
import pl.coderslab.services.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(@Qualifier("dbBookService") BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> findAll() {
        return bookService.getList();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable long id) {
        return bookService.getBookById(id);
    }

    @PostMapping("/")
    public void addBook(@RequestBody Book book) {
        bookService.create(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        bookService.delete(id);
    }
}
