package business.imp;

import business.MoviesBusiness;
import dao.MoviesDAO;
import dao.imp.MoviesDAOimp;
import entity.Movies;

import java.time.LocalDate;
import java.util.Scanner;

public class MoviesBusinessImp implements MoviesBusiness {

    MoviesDAO moviesDAO;

    public MoviesBusinessImp() {
        moviesDAO = new MoviesDAOimp();
    }

    @Override
    public void addMovies(Scanner scanner) {
        Movies movies = new Movies();

        System.out.println("Nhập tiêu đề phim:");
        String title = scanner.nextLine();
        System.out.println("Nhập vào đạo diễn:");
        String director = scanner.nextLine();
        System.out.println("Nhập vào thời lượng:");
        int duration = scanner.nextInt();
        System.out.println("Nhập vào ngày ra mắt:");
        LocalDate date = LocalDate.parse(scanner.nextLine());
        System.out.println("Nhập trạng thái:");
        boolean status = Boolean.parseBoolean(scanner.nextLine());
    }
}
