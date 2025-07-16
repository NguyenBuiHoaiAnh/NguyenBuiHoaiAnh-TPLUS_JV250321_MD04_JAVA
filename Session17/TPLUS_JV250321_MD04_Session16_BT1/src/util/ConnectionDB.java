package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/jv250321_md04_session16_btth";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345678";

    // Mở connection
    public static Connection openConnection() {
        Connection conn = null;
        try{
            // 1. Set Driver cho DriveManager
            Class.forName(DRIVER);
            // 2. Khởi tạo đối tượng Connection từ DriverManager
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

        } catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    // Đóng connection
    public static void closeConnection(Connection conn, CallableStatement callST){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (callST != null){
            try {
                callST.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }

//    public static void main(String[] args) {
//        Connection conn = openConnection();
//        if (conn != null) {
//            System.out.println("Connected to the database");
//        } else  {
//            System.out.println("Failed to make connection");
//        }
//    }
}
