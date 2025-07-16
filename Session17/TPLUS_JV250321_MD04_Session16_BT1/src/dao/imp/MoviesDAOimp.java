package dao.imp;

import dao.MoviesDAO;
import entity.Movies;
import util.ConnectionDB;

import java.sql.*;

public class MoviesDAOimp implements MoviesDAO {

    // Add Movie
    @Override
    public boolean checkMovieIsExist(Movies movies) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call check_movie_is_exist(?,?)}");
            callSt.setInt(1, movies.getMovieId());
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();

            int cnt = callSt.getInt(2);
            if (cnt > 0) {
                return true;
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally{
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }

    @Override
    public void addMovies(Movies movies) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call add_movies(?,?,?,?,?)}");
            callSt.setString(1, movies.getTitle());
            callSt.setString(2, movies.getDirector());
            callSt.setInt(3, movies.getDuration());
            callSt.setDate(4, Date.valueOf(movies.getReleaseDate()));
            callSt.setBoolean(5, movies.isStatus());
            callSt.executeUpdate();
            conn.commit();

        } catch (Exception e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally{
            ConnectionDB.closeConnection(conn,callSt);
        }
    }
}
