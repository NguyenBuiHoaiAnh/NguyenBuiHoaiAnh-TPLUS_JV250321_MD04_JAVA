import util.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProjectManager {
    public boolean assignEmployeeToProject(int empId, int projectId) {
        Connection conn = null;
        CallableStatement callStmt = null;

        try {
            conn = ConnectionDB.getConnection(); // Bạn cần có lớp JDBCUtil để mở kết nối
            conn.setAutoCommit(false); // Bắt đầu transaction

            callStmt = conn.prepareCall("{CALL assign_employee_to_project(?, ?)}");
            callStmt.setInt(1, empId);
            callStmt.setInt(2, projectId);
            callStmt.execute();

            conn.commit(); // Thành công => commit
            System.out.println("Gán nhân viên ID " + empId + " vào dự án ID " + projectId + " thành công!");
            return true;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            try {
                if (conn != null) {
                    try {
                        conn.rollback();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                } // Lỗi => rollback
            } catch (Exception rollbackEx) {
                rollbackEx.printStackTrace();
            }
            System.out.println("Lỗi khi gán nhân viên vào dự án");
        } finally {
            ConnectionDB.closeConnection(conn, callStmt); // đóng kết nối (nếu có lớp hỗ trợ)
        }
        return false;
    }

}
