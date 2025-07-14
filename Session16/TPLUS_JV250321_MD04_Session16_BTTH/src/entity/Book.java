package entity;

import java.util.Scanner;

public class Book {
    private int book_id;
    private String bookName;
    private String bookTitle;
    private int bookPages;
    private String bookAuthor;
    private float bookPrice;
    private int typeId;
    private boolean bookStatus;
    private String typeName;

    public Book() {
    }

    public Book(int book_id, String bookName, String bookTitle, int bookPages, String bookAuthor, float bookPrice, int typeId, boolean bookStatus) {
        this.book_id = book_id;
        this.bookName = bookName;
        this.bookTitle = bookTitle;
        this.bookPages = bookPages;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.typeId = typeId;
        this.bookStatus = bookStatus;
    }

    // --------------------------------------------------------
    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getBookPages() {
        return bookPages;
    }

    public void setBookPages(int bookPages) {
        this.bookPages = bookPages;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public float getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(float bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    // -----------------------------------------------------------

    public void inputData(Scanner scanner){

    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Title: %s, Pages: %d, " +
                             "Author: %s, Price: %.2f, TypeId: %d, Status: %b"
        ,this.book_id,this.bookName,this.bookTitle,this.bookPages,this.bookAuthor,this.bookPrice,this.typeId,this.bookStatus);
    }
}
