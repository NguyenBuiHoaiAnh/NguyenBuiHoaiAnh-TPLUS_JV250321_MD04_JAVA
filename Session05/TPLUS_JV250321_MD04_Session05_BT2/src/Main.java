import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Quản lý tên sinh viên
        Scanner sc = new Scanner(System.in);
        String studentList = "";
        do {
            System.out.println("""
                    ========== QUẢN LÝ TÊN SINH VIÊN ==========
                    
                    1. Thêm tên sinh viên
                    
                    2. Hiển thị danh sách
                    
                    3. Tìm tên sinh viên chứa từ khóa

                    4. Đếm số sinh viên có tên bắt đầu bằng chữ cái nhập vào

                    5. Sắp xếp danh sách tên theo thứ tự A-Z

                    6. Thoát

                    ==========================================
                    
                    Chọn:
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập tên sinh viên: ");
                    String student = sc.nextLine();
                    studentList += student + "\n";
                    System.out.println("Đã thêm.");
                    break;
                case 2:
                    System.out.println("Danh sách sinh viên:\n" + studentList);
                    break;
                case 3:
                    System.out.print("Nhập từ khóa cần tìm:");
                    String searchText = sc.nextLine().toLowerCase();
                    String[] arrSearch = studentList.trim().split("\n");
                    boolean found = false;
                    System.out.println("Kết quả:");
                    for (String s : arrSearch) {
                        if (s.toLowerCase().contains(searchText)) {
                            System.out.println(" " + s);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println(" Không tìm thấy.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập chữ cái bắt đầu: ");
                    char kyTu = sc.nextLine().toLowerCase().charAt(0);
                    String[] arrDem = studentList.trim().split("\n");
                    int dem = 0;
                    for (String s : arrDem) {
                        if (!s.isEmpty() && Character.toLowerCase(s.charAt(0)) == kyTu) {
                            dem++;
                        }
                    }
                    System.out.println("Có " + dem + " sinh viên bắt đầu bằng '" + kyTu + "'");
                    break;
                case 5:
                    String[] arrSapXep = studentList.trim().split("\n");
                    for (int i = 0; i < arrSapXep.length - 1; i++) {
                        for (int j = i + 1; j < arrSapXep.length; j++) {
                            if (arrSapXep[i].compareToIgnoreCase(arrSapXep[j]) > 0) {
                                String temp = arrSapXep[i];
                                arrSapXep[i] = arrSapXep[j];
                                arrSapXep[j] = temp;
                            }
                        }
                    }
                    studentList = "";
                    for (int i = 0; i < arrSapXep.length; i++) {
                        studentList += arrSapXep[i] + "\n";
                    }
                    System.out.println("Đã sắp xếp A-Z.");
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}