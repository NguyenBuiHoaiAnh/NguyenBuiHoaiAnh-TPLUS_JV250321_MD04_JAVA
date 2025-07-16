package dao;

import entity.Movies;

public interface MoviesDAO {
    // Add Movie
    public boolean checkMovieIsExist(Movies movies);
    public void addMovies(Movies movies);

    //
}
