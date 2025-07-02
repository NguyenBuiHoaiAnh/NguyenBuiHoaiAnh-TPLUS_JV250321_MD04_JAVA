import java.util.Scanner;

public class Main {
    public static Products[] products = new Products[100];
    public static int curr = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Show All Products");
            System.out.println("3. Find Products");
            System.out.println("4. Exit");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    showAllProducts();
                    break;
                case 3:
                    findProducts(scanner);
                    break;
                case 4:
                    System.exit(0);
            }
        }
    }

    public static void addProduct(Scanner scanner) {
        Products newProducts = new Products();

        System.out.println("Thêm ID:");
        newProducts.setId(Integer.parseInt(scanner.nextLine()));

        System.out.println("Thêm Name:");
        newProducts.setName(scanner.nextLine());

        System.out.println("Thêm Price:");
        newProducts.setPrice(Double.parseDouble(scanner.nextLine()));

        products[curr++] = newProducts;
        System.out.println("Đã thêm thành công.");
    }

    public static void showAllProducts() {
        for (int i = 0; i < curr; i++) {
            products[i].displayData();
        }
    }

    public static void findProducts(Scanner scanner) {
        System.out.println("Enter the product name to find:");
        String name = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < curr; i++) {
            if (products[i].getName().equalsIgnoreCase(name)) {
                System.out.println("Product found:");
                products[i].displayData();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Product not found.");
        }
    }

}