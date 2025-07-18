package entity;

public class Order {


    private String code;
    private double amount;

    public Order() {
    }

    public Order(String code, double amount) {
        this.code = code;
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("Code: %s, Amount: %s", code, amount);
    }

}
