package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Movie {
    private int id;
    private String title;
    private String director;
    private LocalDate releaseDate;
    private double rating;

    public Movie() {
    }

    public Movie(int id, String title, String director, LocalDate releaseDate, double rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseDate = releaseDate;
        this.rating = rating;
    }

    // ----------------------------------------------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
    // ------------------------------------------------------


    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("ID: %d, Title: %s,Director: %s, ReleaseDate: %s, Rating: %f",
                this.id, this.title, this.director, formatter.format(this.releaseDate), this.rating);
    }
}
