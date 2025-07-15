package business;

import entity.Book;

import java.util.List;

public interface BookBusiness {
    List<Book> findAll();

    boolean bookIsExists(String bookId);

    boolean addBook(Book book);
}
