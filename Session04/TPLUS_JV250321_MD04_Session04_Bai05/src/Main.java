public class Main {
    public static void main(String[] args) {
        // So sánh hiệu suất giữa String, StringBuilder và StringBuffer

        long startTime, endTime;

        // Test String
        String str = "Hello";
        startTime = System.currentTimeMillis();
        for (int i = 0; i <= 10000; i++) {
            str = str + " World";
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by String: " + (endTime - startTime) + "ms");

        // Test StringBuilder
        StringBuilder sb = new StringBuilder(str);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sb.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuilder: " + (endTime - startTime) + "ms");

        // Test StringBuffer
        StringBuffer sbf = new StringBuffer(str);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            sbf.append(" World");
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken by StringBuffer: " + (endTime - startTime) + "ms");

        System.out.println("\nNhận xét:");
        System.out.println("- String: Không hiệu quả cho phép nối chuỗi nhiều lần do tạo ra nhiều đối tượng mới.");
        System.out.println("- StringBuilder: Hiệu quả và nhanh chóng, thích hợp cho nhiều thao tác nối chuỗi trong một luồng.");
        System.out.println("- StringBuffer: Tương tự như StringBuilder nhưng an toàn với đa luồng, có thể chậm hơn một chút do đồng bộ hóa.");
    }
}