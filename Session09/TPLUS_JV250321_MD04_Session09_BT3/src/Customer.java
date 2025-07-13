public class Customer {
    private String name;
    private int customerType; // 1: VIP, 2: Thường
    private int loyaltyPoints;
    private int debt;

    public Customer(String name, int customerType, int loyaltyPoints, int debt) {
        this.name = name;
        this.customerType = customerType;
        this.loyaltyPoints = loyaltyPoints;
        this.debt = debt;
    }

    public String getName() {
        return name;
    }

    public boolean isVIP() {
        return customerType == 1;
    }

    public boolean hasLoyaltyPoints() {
        return loyaltyPoints > 0;
    }

    public boolean hasNoDebt() {
        return debt == 0;
    }

    public boolean isEligibleForPromotion() {
        return isVIP() && hasLoyaltyPoints() && hasNoDebt();
    }
}
