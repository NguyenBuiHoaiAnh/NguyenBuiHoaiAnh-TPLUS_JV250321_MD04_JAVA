package ra.entity;

import java.util.Scanner;

public class Categories implements IShop {
    private static int AUTO_ID = 1;
    private int catalogId;
    private String catalogName;
    private String descriptions;
    private boolean catalogStatus;

    public Categories() {
        this.catalogId = AUTO_ID++;
    }

    public Categories(String catalogName, String descriptions, boolean catalogStatus) {
        this.catalogId = AUTO_ID++;
        this.catalogName = catalogName;
        this.descriptions = descriptions;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    public void inputData(Scanner scanner, Categories[] arrCategories, int index) {
        System.out.print("Nhập tên danh mục: ");
        while (true) {
            String name = scanner.nextLine();
            boolean exists = false;
            for (int i = 0; i < index; i++) {
                if (arrCategories[i].getCatalogName().equalsIgnoreCase(name)) {
                    exists = true;
                    break;
                }
            }
            if (!exists && name.length() <= 50) {
                this.catalogName = name;
                break;
            } else {
                System.out.print("Tên không hợp lệ hoặc đã tồn tại, nhập lại: ");
            }
        }

        System.out.print("Nhập mô tả: ");
        this.descriptions = scanner.nextLine();

        System.out.print("Nhập trạng thái (true/false): ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                this.catalogStatus = Boolean.parseBoolean(input);
                break;
            } else {
                System.out.print("Chỉ được nhập true hoặc false: ");
            }
        }
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d | Tên: %s | Mô tả: %s | Trạng thái: %s\n",
                catalogId, catalogName, descriptions, catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}

