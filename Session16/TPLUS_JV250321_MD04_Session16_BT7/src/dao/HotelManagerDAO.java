package dao;

import entity.Booking;
import util.ConnectionDB;

import java.sql.*;

public class HotelManagerDAO {
    public boolean bookRoom(Booking booking){
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call book_room(?,?,?,?,?)}");
            callSt.setInt(1, booking.getRoomId());
            callSt.setString(2, booking.getCustomerName());
            callSt.setDate(3, Date.valueOf(booking.getStartDate()));
            callSt.setDate(4, Date.valueOf(booking.getEndDate()));
            callSt.registerOutParameter(5, Types.VARCHAR);
            callSt.executeUpdate();

            conn.commit();
            return true;

        }catch(Exception e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
        return false;
    }
}
