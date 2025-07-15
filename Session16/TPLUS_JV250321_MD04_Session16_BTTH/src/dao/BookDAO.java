package dao;

import entity.Book;
import entity.StaticBook;

import java.util.List;

public interface BookDAO {
    List<Book> findAll();

    // Thêm mới
    boolean bookNameIsExists(String bookName);

    boolean addBook(Book book);

    //
    Book getAllBooksById(String bookId);

    boolean updateBook(Book book);

    boolean deleteBook(String bookId);

    List<Book> getBooksByName(String bookName);

    List<StaticBook>  getStaticBooksByAuthor();

}
