package entity;

import entity.Movie;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class MovieManager<T extends Movie> {
    private final List<T> movieList = new ArrayList<>();

    public void addMovie(T movie) {
        movieList.add(movie);
    }

    public void editMovie(int id, Scanner scanner) {
        Optional<T> opt = findById(id);
        if (opt.isPresent()) {
            T movie = opt.get();
            System.out.print("Nhập tiêu đề mới: ");
            movie.setTitle(scanner.nextLine());
            System.out.print("Nhập đạo diễn mới: ");
            movie.setDirector(scanner.nextLine());
            System.out.print("Nhập ngày phát hành mới (yyyy-MM-dd): ");
            movie.setReleaseDate(LocalDate.parse(scanner.nextLine()));
            System.out.print("Nhập đánh giá mới: ");
            movie.setRating(Double.parseDouble(scanner.nextLine()));
            System.out.println("Đã cập nhật phim.");
        } else {
            System.out.println("Không tìm thấy phim với ID: " + id);
        }
    }

    public void deleteMovie(int id) {
        movieList.removeIf(movie -> movie.getId() == id);
        System.out.println("Đã xóa phim nếu tồn tại.");
    }

    public void displayAll() {
        movieList.forEach(System.out::println);
    }

    public void displayHighRated() {
        movieList.stream()
                .filter(movie -> movie.getRating() > 8.0)
                .forEach(System.out::println);
    }

    public void searchByTitle(String title) {
        Optional<T> result = movieList.stream()
                .filter(movie -> movie.getTitle().equalsIgnoreCase(title))
                .findFirst();
        result.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Không tìm thấy phim.")
        );
    }

    private Optional<T> findById(int id) {
        return movieList.stream()
                .filter(movie -> movie.getId() == id)
                .findFirst();
    }
}