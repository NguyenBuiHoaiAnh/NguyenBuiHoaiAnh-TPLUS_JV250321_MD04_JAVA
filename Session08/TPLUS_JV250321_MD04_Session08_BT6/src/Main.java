public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[100];
        int curr = 0;

        products[curr++] = new Product("Milk",100);
        products[curr++] = new Product("Apple",200);
        products[curr++] = new Product("Orange", 300);

        double total = calculationTotal(products,curr);
        double tax = calculationTax(total);
        double final



    }

    public static double calculationTotal(Product[] products, int curr){
        double total = 0;
        for (int i = 0; i < curr; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public static double calculationTax(double total){
        return total + 0.1;
    }

    public static double calculateFinalAmount(double total, double tax) {
        return total + tax;
    }

    public static void printInvoice(Product[] products, int count, double total, double tax, double finalAmount) {
        System.out.println("========== INVOICE ==========");
        System.out.printf("%-15s %10s\n", "Name", "Price");
        System.out.println("------------------------------");

        for (int i = 0; i < count; i++) {
            System.out.printf("%-15s %10.2f\n", products[i].getName(), products[i].getPrice());
        }

        System.out.println("------------------------------");
        System.out.printf("%-15s %10.2f\n", "Total", total);
        System.out.printf("%-15s %10.2f\n", "Tax (10%)", tax);
        System.out.printf("%-15s %10.2f\n", "Final Amount", finalAmount);
    }
}