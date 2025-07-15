package dao.IMP;

import dao.BookDAO;
import entity.Book;
import entity.BookType;
import entity.StaticBook;
import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImp implements BookDAO {
    @Override
    public List<Book> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBooks = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_all_book_if_price_ASC()}");
            ResultSet rs = callSt.executeQuery();
            listBooks = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setBookTitle(rs.getString("book_title"));
                book.setBookPages(rs.getInt("book_pages"));
                book.setBookAuthor(rs.getString("book_author"));
                book.setBookPrice(rs.getInt("book_price"));
                book.setBookStatus(rs.getBoolean("book_status"));
                book.setTypeId(rs.getInt("type_id"));

                listBooks.add(book);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listBooks;
    }

    @Override
    public boolean bookNameIsExists(String bookName){
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call book_name_is_exists(?,?)}");

            callSt.setString(1, bookName);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();

            int cntBook = callSt.getInt(2);
            if (cntBook > 0) {
                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    @Override
    public boolean addBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call add_book(?, ?, ?, ?, ?, ?, ?)}");

            callSt.setString(1, book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setString(3, book.getBookTitle());
            callSt.setInt(4, book.getBookPages());
            callSt.setString(5, book.getBookAuthor());
            callSt.setFloat(6, book.getBookPrice());
            callSt.setBoolean(7, book.isBookStatus());

            callSt.executeUpdate();
            return true;

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    @Override
    public Book getAllBooksById(String bookId) {
        Connection conn = null;
        CallableStatement callSt = null;

        Book book = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_book_by_id(?)}");

            callSt.setString(1, bookId);
            ResultSet rs = callSt.executeQuery();

            if (rs.next()) {
                book = new Book();
                book.setBookId(rs.getString("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setBookTitle(rs.getString("book_title"));
                book.setBookPages(rs.getInt("book_pages"));
                book.setBookAuthor(rs.getString("book_author"));
                book.setBookPrice(rs.getInt("book_price"));
                book.setBookStatus(rs.getBoolean("book_status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return book;
    }

    @Override
    public boolean updateBook(Book book) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_book(?,?,?,?,?,?,?)}");
            callSt.setString(1, book.getBookId());
            callSt.setString(2, book.getBookName());
            callSt.setString(3, book.getBookTitle());
            callSt.setInt(4, book.getBookPages());
            callSt.setString(5, book.getBookAuthor());
            callSt.setFloat(6, book.getBookPrice());
            callSt.setBoolean(7, book.isBookStatus());
            callSt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }

    @Override
    public boolean deleteBook(String bookId) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_book(?)}");

            callSt.setString(1, bookId);
            callSt.executeUpdate();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    @Override
    public List<Book> getBooksByName(String bookName) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Book> listBooks = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_book_by_name(?)}");
            callSt.setString(1, bookName);
            ResultSet rs = callSt.executeQuery();

            listBooks = new ArrayList<>();
            while (rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getString("book_id"));
                book.setBookName(rs.getString("book_name"));
                book.setBookTitle(rs.getString("book_title"));
                book.setBookPages(rs.getInt("book_pages"));
                book.setBookAuthor(rs.getString("book_author"));
                book.setBookPrice(rs.getInt("book_price"));
                book.setBookStatus(rs.getBoolean("book_status"));
                book.setTypeId(rs.getInt("book_type_id"));
                book.setTypeName(rs.getString("book_type_name"));

                listBooks.add(book);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listBooks;
    }

    @Override
    public List<StaticBook> getStaticBooksByAuthor() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<StaticBook> listStaticBook = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call search_book_by_name()}");
            ResultSet rs = callSt.executeQuery();

            listStaticBook = new ArrayList<>();
            while (rs.next()) {
                StaticBook staticBook = new StaticBook();
                staticBook.setBookAuthor(rs.getString("book_author"));
                staticBook.setCntBook(rs.getString("count_book_name"));
                listStaticBook.add(staticBook);

            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return listStaticBook;
    }




}
