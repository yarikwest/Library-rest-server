package pl.coderslab.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.dao.BookDao;
import pl.coderslab.entities.Book;

import java.util.List;

@Service
public class DbBookService implements BookService {
    private final BookDao bookDao;

    @Autowired
    public DbBookService(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public List<Book> getList() {
        return bookDao.findAll();
    }

    @Override
    public void create(Book book) {
        bookDao.create(book);
    }

    @Override
    public Book getBookById(long id) {
        return bookDao.read(id);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public void delete(long id) {
        bookDao.delete(id);
    }
}
