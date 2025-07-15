package presentation;

import business.BookBusiness;
import business.IMP.BookBusinessImp;
import entity.Book;
import validate.Validator;

import java.util.Scanner;

public class BookManagement {

    private BookBusiness bookBusiness;

    public BookManagement() {
        bookBusiness = new BookBusinessImp();
    }

    public void bookManagement(Scanner scanner) {
        boolean isExit = true;
        do {
            System.out.println("""
                    ********************BOOK****************\s
                    1. Danh sách sách\s
                    2. Thêm mới sách\s
                    3. Thêm mới nhiều sách\s
                    4. Cập nhật sách\s
                    5. Xóa sách\s
                    6. Tìm kiếm sách\s
                    7. Thông kê số lượng sách theo tác giả\s
                    8. Thoát\s
                    Lựa chọn của bạn:
                    """);
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayListBookType();
                    break;
                case 2:
                    createBook(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    isExit = false;
                    break;
            }
        } while (isExit);
    }

    public void displayListBookType() {
        bookBusiness.findAll().forEach(System.out::println);
    }

    public void createBook(Scanner scanner) {
        Book book = new Book();
        book.setBookId(inputIDBook(scanner));
        book.setBookName(inputBookName(scanner));

        System.out.println("Nhập vào tiêu đề:");
        book.setBookName(scanner.nextLine());
        System.out.println("Nhập vào số trang:");
        book.setBookPages(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhập vào tên tác giả:");
        book.setBookAuthor(scanner.nextLine());
        System.out.println("Nhập vào giá:");
        book.setBookPrice(Float.parseFloat(scanner.nextLine()));
        System.out.println("Nhập vào trạng thái:");
        book.setBookStatus(Boolean.parseBoolean(scanner.nextLine()));
        System.out.println("Nhập vào typeID:");
        book.setTypeId(Integer.parseInt(scanner.nextLine()));

        boolean result = bookBusiness.addBook(book);
        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.err.println("Có lỗi trong quá trình thêm mới sách");
        }
    }

    public String inputIDBook(Scanner scanner) {
        System.out.println("Nhập ID sách:");
        do {
            String bookId = scanner.nextLine();
            if (Validator.isEmpty(bookId)) {
                if (bookBusiness.bookIsExists(bookId)) {
                    return bookId;
                } else {
                    System.err.println("ID đã tồn tại.");
                }
            } else {
                System.err.println("Vui lòng nhập ID sách");
            }
        } while (true);

    }

    public String inputBookName(Scanner scanner) {
        System.out.println("Nhập vào tên sách:");
        do {
            String bookName = scanner.nextLine();
            if (Validator.isEmpty(bookName)) {
                if (bookBusiness.bookIsExists(bookName)) {
                    return bookName;
                } else {
                    System.err.println("Tên đã tồn tại.");
                }
            } else {
                System.err.println("Vui lòng nhập tên sách");
            }
        } while (true);
    }



}