import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class BankManager {
    public boolean accountIsExist(int id){
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call account_name_is_exist(?,?)}");
            callSt.setInt(1, id);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();

            int cnt = callSt.getInt(2);

            if (cnt > 0){
                return true;
            }

            conn.commit();
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
        return false;
    }

    public boolean transfer(int senderID,int receiverID,int amount){
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{call transfer_funds(?,?,?)}");
            callSt.setInt(1, senderID);
            callSt.setInt(2, receiverID);
            callSt.setDouble(3, amount);
            callSt.executeQuery();
            conn.commit();
            return true;
        } catch (Exception e){
            System.err.println(e.getMessage());
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
        return false;
    }
}

