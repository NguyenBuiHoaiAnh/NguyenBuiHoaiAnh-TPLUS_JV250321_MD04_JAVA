import entity.Movie;
import entity.MovieManager;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static final MovieManager<Movie> manager = new MovieManager<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static int nextId = 1;

    public static void main(String[] args) {

        do {
            System.out.println("\n===== MENU QUẢN LÝ PHIM =====");
            System.out.println("1. Thêm phim");
            System.out.println("2. Sửa phim");
            System.out.println("3. Xóa phim");
            System.out.println("4. Hiển thị tất cả phim");
            System.out.println("5. Hiển thị phim có rating > 8.0");
            System.out.println("6. Tìm phim theo tiêu đề");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        addMovie();
                        break;
                    case 2:
                        System.out.print("Nhập ID phim cần sửa: ");
                        manager.editMovie(Integer.parseInt(scanner.nextLine()), scanner);
                        break;
                    case 3:
                        System.out.print("Nhập ID phim cần xóa: ");
                        manager.deleteMovie(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 4:
                        manager.displayAll();
                        break;
                    case 5:
                        System.out.print("Nhập tiêu đề phim cần tìm: ");
                        manager.searchByTitle(scanner.nextLine());
                    case 6 :
                        System.exit(0);
                }
            } catch (Exception e) {
                System.out.println("Đầu vào không hợp lệ: " + e.getMessage());
            }
        } while (true);
    }

    private static void addMovie() {
        Movie movie = new Movie();
        movie.setId(nextId++);
        System.out.print("Nhập tiêu đề phim: ");
        movie.setTitle(scanner.nextLine());
        System.out.print("Nhập đạo diễn: ");
        movie.setDirector(scanner.nextLine());
        System.out.print("Nhập ngày phát hành (yyyy-MM-dd): ");
        movie.setReleaseDate(LocalDate.parse(scanner.nextLine()));
        System.out.print("Nhập rating: ");
        double rating = Double.parseDouble(scanner.nextLine());
        if (rating < 0 || rating > 10) throw new IllegalArgumentException("Rating phải từ 0 đến 10");
        movie.setRating(rating);

        manager.addMovie(movie);
        System.out.println("Thêm phim thành công");
    }
}
