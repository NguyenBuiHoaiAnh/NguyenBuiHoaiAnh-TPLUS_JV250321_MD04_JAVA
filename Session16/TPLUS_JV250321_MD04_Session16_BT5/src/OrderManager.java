import util.ConnectionDB;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class OrderManager {
    public boolean placeOrder(int customerId, BigDecimal totalAmount,
                              int productId, int quantity) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);
            callSt = conn.prepareCall("{call place_order(?,?,?,?)}");

            callSt.setInt(1, customerId);
            callSt.setBigDecimal(2, totalAmount);
            callSt.setInt(3, productId);
            callSt.setInt(4, quantity);
            callSt.executeUpdate();
            conn.commit();

            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return false;
    }
}
