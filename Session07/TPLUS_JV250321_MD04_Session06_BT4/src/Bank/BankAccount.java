package Bank;

public class BankAccount implements IBank {
    private String accountId;
    private double balance;
    private String userName;
    private String phoneNumber;

    // Constructor
    public BankAccount(String accountId, String userName, String phoneNumber) {
        this.accountId = accountId;
        this.userName = userName;
        this.phoneNumber = phoneNumber;
        this.balance = 0.0;
    }

    // Nạp tiền
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Đã nhận tiền: " + amount);
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0.");
        }
    }

    // Rút tiền
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Đã rút tiền: " + amount);
        } else {
            System.out.println("Rút không thành công. Số tiền không hợp lệ hoặc vượt quá số dư.");
        }
    }

    // Hiển thị số dư
    public void displayBalance() {
        System.out.println("Số dư tài khoản (" + accountId + "): " + balance);
    }

    // Getter
//    public double getBalance() {
//        return balance;
//    }
}
