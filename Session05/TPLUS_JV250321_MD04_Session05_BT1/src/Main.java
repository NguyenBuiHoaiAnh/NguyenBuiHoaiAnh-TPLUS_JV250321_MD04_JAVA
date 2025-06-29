import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            System.out.println("""
                    ***************************** MENU *****************************
                    1. Nhập chuỗi
                    2. Đếm số ký tự thường, hoa, số, đặc biệt"
                    3. Đảo ngược chuỗi
                    4. Kiểm tra Palindrome
                    5. Chuẩn hóa chuỗi (xóa khoảng trắng dư thừa, viết hoa chữ cái đầu)
                    6. Thoát
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("Nhập chuỗi: ");
                    input = sc.nextLine();
                    break;
                case 2:
                    int upper = 0, normal = 0, digit = 0, special = 0;

                    for (int i = 0; i < input.length(); i++) {
                        char ch = input.charAt(i);
                        if (Character.isLowerCase(ch)) {
                            normal++;
                        } else if (Character.isUpperCase(ch)) {
                            upper++;
                        } else if (Character.isDigit(ch)) {
                            digit++;
                        } else {
                            special++;
                        }
                    }
                    System.out.println("Số ký tự thường: " + normal);
                    System.out.println("Số ký tự hoa: " + upper);
                    System.out.println("Số chữ số: " + digit);
                    System.out.println("Số ký tự đặc biệt: " + special);
                    break;
                case 3:
                    StringBuilder reversed = new StringBuilder(input).reverse();
                    System.out.println("Chuỗi đảo ngược: " + reversed);
                    break;
                case 4:
                    boolean isPalindrome = true;
                    for (int i = 0; i < input.length() / 2; i++) {
                        if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                            isPalindrome = false;
                            break;
                        }
                    }
                    if (isPalindrome) {
                        System.out.printf("%s chuỗi Palindrome.\n", input);
                    } else {
                        System.out.printf("%s Không phải là chuỗi Palindrome.", input);
                    }
                    break;
                case 5:
                    // 1. Xoá khoảng trắng dư & chuyển về chữ thường
                    input = input.trim().toLowerCase();
                    String temp = "";
                    boolean spaceFlag = false;

                    for (int i = 0; i < input.length(); i++) {
                        char c = input.charAt(i);
                        if (Character.isWhitespace(c)) {
                            if (!spaceFlag) {
                                temp += " ";
                                spaceFlag = true;
                            }
                        } else {
                            temp += c;
                            spaceFlag = false;
                        }
                    }
                    // 2. Viết hoa chữ cái đầu mỗi từ
                    String result = "";
                    boolean capitalizeNext = true;

                    for (int i = 0; i < temp.length(); i++) {
                        char c = temp.charAt(i);
                        if (Character.isWhitespace(c)) {
                            result += c;
                            capitalizeNext = true;
                        } else {
                            if (capitalizeNext) {
                                result += Character.toUpperCase(c);
                                capitalizeNext = false;
                            } else {
                                result += c;
                            }
                        }
                    }

                    input = result.trim(); // gán lại chuỗi sau chuẩn hoá
                    System.out.println("Chuỗi sau khi chuẩn hóa: " + input);
                    break;
                case 6:
                    System.exit(0);
                    break;
            }
        } while (true);
    }
}