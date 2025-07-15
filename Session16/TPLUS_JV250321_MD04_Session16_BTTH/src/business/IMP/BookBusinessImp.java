package business.IMP;

import business.BookBusiness;
import dao.BookDAO;
import dao.IMP.BookDAOImp;
import entity.Book;

import java.util.List;

public class BookBusinessImp implements BookBusiness {
    private BookDAO bookDAO;

    public BookBusinessImp() {
        bookDAO = new BookDAOImp();
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public boolean bookIsExists(String bookId) {
        return bookDAO.bookNameIsExists(bookId);
    }

    @Override
    public boolean addBook(Book book) {
        return bookDAO.addBook(book);
    }
}
