package dao;

import entity.Book;
import java.util.List;

public interface BookDAO {
    List<Book> findAll();

    boolean bookNameIsExists(String bookName);

    boolean addBook(Book book);




}
