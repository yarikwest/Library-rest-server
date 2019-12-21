package pl.coderslab.services;

import pl.coderslab.entities.Book;

import java.util.List;

public interface BookService {

    List<Book> getList();

    void create(Book book);

    Book getBookById(long id);

    void update(Book book);

    void delete(long id);
}
