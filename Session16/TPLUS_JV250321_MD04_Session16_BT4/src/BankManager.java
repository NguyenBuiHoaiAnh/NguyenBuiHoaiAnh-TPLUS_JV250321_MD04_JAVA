import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class BankManager {
    public void transfer(int senderID,int receiverID,int amount){
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call transfer_funds(?,?,?)}");
            callSt.setInt(1, senderID);
            callSt.setInt(2, receiverID);
            callSt.setInt(3, amount);
            callSt.execute();
            conn.commit();
            System.out.println("Transfer success.");
        } catch (Exception e){
            if (conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            ConnectionDB.closeConnection(conn,callSt);
        }
    }
}

