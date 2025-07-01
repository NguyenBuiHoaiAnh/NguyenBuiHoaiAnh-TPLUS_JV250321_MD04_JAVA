package Bank;

public class Main {
    public static void main(String[] args) {
        BankAccount accountA = new BankAccount("A001", "Nguyễn Văn A", "0123456789");
        BankAccount accountB = new BankAccount("B001", "Nguyễn Văn B", "0987654321");

        // Nạp tiền vào tài khoản A
        accountA.deposit(1000);

        // Chuyển tiền từ A → B
        double transferAmount = 300;
        accountA.withdraw(transferAmount);     // Rút từ A
        accountB.deposit(transferAmount);      // Nạp vào B

        // Hiển thị số dư
        accountA.displayBalance();
        accountB.displayBalance();
    }
}
