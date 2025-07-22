package presentation;

import business.product.ProductBusiness;
import business.product.imp.ProductBusinessImp;
import model.Product;
import validate.Validator;

import java.util.Scanner;

public class ProductManagement {

    private ProductBusiness productBusiness1;

    public ProductManagement () {
        productBusiness1 =  new ProductBusinessImp();
    }

    public void ProductManagement(Scanner scanner) {

        boolean isExit = false;
        do {
            System.out.println("=========== QUẢN LÍ SẢN PHẨM =============");
            System.out.println("1. Hiển thị danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm mới");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm theo ID");
            System.out.println("5. Tìm kiếm theo Brand");
            System.out.println("6. Tìm kiếm theo khoảng giá");
            System.out.println("7. Tìm kiếm theo tồn kho");
            System.out.println("8. Quay lại Menu");
            System.out.print("Nhập lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    productBusiness1.findAll().forEach(System.out::println);
                    break;
                case 2:
                    inputAddProduct(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    isExit = true;
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 đến 8");
            }
        } while (!isExit);
    }

    // Add Product
    public void inputAddProduct(Scanner scanner) {
        Product product = new Product();

        product.setProductName(inputProductName(scanner));

        System.out.println("Nhập vào hãng sản phẩm");
        product.setBrand(scanner.nextLine());
        System.out.println("Nhập vào giá sản phẩm");
        product.setPrice(Double.parseDouble(scanner.nextLine()));
        System.out.println("Nhập vào số lượng");
        product.setStock(Integer.parseInt(scanner.nextLine()));

        boolean result = productBusiness1.addProduct(product);

        if (result) {
            System.out.println("Thêm mới thành công");
        } else {
            System.out.println("Có lỗi trong quá trình thêm mới");
        }
    }

    // Input Validate
    public String inputProductName(Scanner scanner) {
        System.out.println("Nhập vào tên sản phẩm");
        do {
            String name = scanner.nextLine();
            if (!Validator.isEmpty(name)) {
                if (!productBusiness1.checkProduct(name)){
                    return name;
                } else {
                    System.out.println("Không tồn tại tên");
                }
            } else {
                System.out.println("Không để trống tên");
            }
        } while (true);
    }

    // ------------------------------------------------------------



}
