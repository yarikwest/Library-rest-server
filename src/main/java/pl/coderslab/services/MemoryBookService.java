package pl.coderslab.services;

import org.springframework.stereotype.Service;
import pl.coderslab.entities.Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemoryBookService implements BookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel",
                "Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.",
                "Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy",
                "Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    @Override
    public List<Book> getList() {
        return list;
    }

    @Override
    public void create(Book book) {
        list.add(book);
    }

    @Override
    public Book getBookById(long id) {
        return list.stream()
                .filter(book -> book.getId() == id)
                .findAny()
                .orElse(null);
    }

    @Override
    public void update(Book book) {
        list.set(list.indexOf(getBookById(book.getId())), book);
    }

    @Override
    public void delete(long id) {
        list.remove(getBookById(id));
    }
}
