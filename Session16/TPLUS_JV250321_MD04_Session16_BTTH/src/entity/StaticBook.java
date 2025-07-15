package entity;

public class StaticBook {
    private String bookAuthor;
    private String cntBook;

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getCntBook() {
        return cntBook;
    }

    public void setCntBook(String cntBook) {
        this.cntBook = cntBook;
    }

    @Override
    public String toString() {
        return String.format("Tên tác giả: %s, Số lượng sách: %s", bookAuthor, cntBook);
    }
}
