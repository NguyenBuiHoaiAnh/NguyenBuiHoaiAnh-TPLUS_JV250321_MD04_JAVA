import util.ConnectionDB;
import util.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

public class StudentManagement {
    public void addStudents(List<Student> students) {

        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false); // Bắt đầu transaction

            callSt = conn.prepareCall("{CALL add_students(?, ?)}");

            for (Student s : students) {
                callSt.setString(1, s.getName());
                callSt.setInt(2, s.getAge());
                callSt.executeUpdate();
            }

            conn.commit(); // Xác nhận transaction
            System.out.println("Đã thêm sinh viên thành công.");
        } catch (Exception e) {
            try {
                if (conn != null) {
                    conn.rollback();
                } // Quay lui nếu lỗi
                System.err.println("Lỗi khi thêm sinh viên");
            } catch (Exception ex) {
                System.err.println("Lỗi khi rollback");
            }
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public void updateStudents(Student students) {
        Connection conn = null;
        CallableStatement callSt = null;

        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{CALL update_students(?,?,?)}");

            callSt.setInt(1, students.getId());
            callSt.setString(2, students.getName());
            callSt.setInt(3, students.getAge());

            callSt.executeUpdate();
            conn.commit();
            System.out.println("Đã update thành công");

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    public void deleteStudents(int maxAge) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            conn.setAutoCommit(false);

            callSt = conn.prepareCall("{CALL delete_students_by_age(?,?)}");
            callSt.setInt(1, maxAge);
            callSt.registerOutParameter(2, Types.INTEGER);
            callSt.execute();
            conn.commit();

            int result = callSt.getInt(2);
            if (result > 0) {
                System.out.printf("Xóa thành công %d học sinh có tuổi nhỏ hơn : %d%n", result, maxAge);
            } else {
                System.out.printf("Không tìm thấy học sinh nào có tuổi nhỏ hơn : %d%n", maxAge);
            }

        } catch (Exception e){
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        } finally{
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}
