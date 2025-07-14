package dao.IMP;

import dao.BookDAO;
import entity.Book;
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
                book.setBook_id(rs.getInt("book_id"));
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
}
