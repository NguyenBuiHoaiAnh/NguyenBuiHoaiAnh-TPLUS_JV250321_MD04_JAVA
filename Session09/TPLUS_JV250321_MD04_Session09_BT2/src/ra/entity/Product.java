package ra.entity;

import java.util.Scanner;

public class Product implements IShop {
    private String productId;
    private String productName;
    private float price;
    private String description;
    private int catalogId;
    private int productStatus; // 0: Đang bán, 1: Hết hàng, 2: Không bán

    public Product() {
    }

    public Product(String productId, String productName, float price, String description, int catalogId, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.description = description;
        this.catalogId = catalogId;
        this.productStatus = productStatus;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData(Scanner scanner, Product[] arrProduct, int indexProduct, Categories[] arrCategories, int indexCatalog) {
        System.out.print("Nhập mã sản phẩm (Cxxx/Sxxx/Axxx): ");
        while (true) {
            String code = scanner.nextLine();
            boolean exists = false;
            for (int i = 0; i < indexProduct; i++) {
                if (arrProduct[i].getProductId().equalsIgnoreCase(code)) {
                    exists = true;
                    break;
                }
            }
            if (!exists && code.matches("[CSA][0-9]{3}")) {
                this.productId = code;
                break;
            } else {
                System.out.print("Mã không hợp lệ hoặc đã tồn tại, nhập lại: ");
            }
        }

        System.out.print("Nhập tên sản phẩm: ");
        while (true) {
            String name = scanner.nextLine();
            boolean exists = false;
            for (int i = 0; i < indexProduct; i++) {
                if (arrProduct[i].getProductName().equalsIgnoreCase(name)) {
                    exists = true;
                    break;
                }
            }
            if (!exists && name.length() >= 10 && name.length() <= 50) {
                this.productName = name;
                break;
            } else {
                System.out.print("Tên không hợp lệ hoặc đã tồn tại, nhập lại: ");
            }
        }

        System.out.print("Nhập giá sản phẩm (>0): ");
        while (true) {
            float price = Float.parseFloat(scanner.nextLine());
            if (price > 0) {
                this.price = price;
                break;
            } else {
                System.out.print("Giá phải > 0, nhập lại: ");
            }
        }

        System.out.print("Nhập mô tả sản phẩm: ");
        this.description = scanner.nextLine();

        System.out.println("Chọn danh mục sản phẩm: ");
        for (int i = 0; i < indexCatalog; i++) {
            arrCategories[i].displayData();
        }
        while (true) {
            System.out.print("Nhập mã danh mục: ");
            int catId = Integer.parseInt(scanner.nextLine());
            boolean found = false;
            for (int i = 0; i < indexCatalog; i++) {
                if (arrCategories[i].getCatalogId() == catId) {
                    found = true;
                    break;
                }
            }
            if (found) {
                this.catalogId = catId;
                break;
            } else {
                System.out.print("Không tìm thấy mã danh mục, nhập lại: ");
            }
        }

        System.out.print("Nhập trạng thái sản phẩm (0: Đang bán, 1: Hết hàng, 2: Không bán): ");
        while (true) {
            int status = Integer.parseInt(scanner.nextLine());
            if (status >= 0 && status <= 2) {
                this.productStatus = status;
                break;
            } else {
                System.out.print("Trạng thái không hợp lệ, nhập lại: ");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.printf("Mã: %s | Tên: %s | Giá: %.2f | Mô tả: %s | Danh mục: %d | Trạng thái: %s\n",
                productId, productName, price, description, catalogId,
                productStatus == 0 ? "Đang bán" : productStatus == 1 ? "Hết hàng" : "Không bán");
    }
}
