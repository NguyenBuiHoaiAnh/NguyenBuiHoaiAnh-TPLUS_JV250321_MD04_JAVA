package ShopList;

import java.io.Serializable;

public class CategoryManagement implements ICRUD {
    private Category[] categories = new Category[100];
    private int count = 0;

    @Override
    public Category[] findAll() {
        Category[] result = new Category[count];
        for (int i = 0; i < count; i++) {
            result[i] = categories[i];
        }
        return result;
    }

    @Override
    public void addCategory(Category category) {
        categories[count++] = category;
        System.out.println("Danh mục đã được thêm.");
    }

    @Override
    public void updateCategory(Category category) {
        for (int i = 0; i < count; i++) {
            if (categories[i].getId() == category.getId()) {
                categories[i].setName(category.getName());
                categories[i].setDescription(category.getDescription());
                System.out.println("Danh mục đã được cập nhật.");
                return;
            }
        }
        System.out.println("Không tìm thấy ID danh mục cần cập nhật.");
    }

    @Override
    public void deleteById(int id) {
        for (int i = 0; i < count; i++) {
            if (categories[i].getId() == id) {
                // Xoá phần tử và dồn mảng
                for (int j = i; j < count - 1; j++) {
                    categories[j] = categories[j + 1];
                }
                categories[--count] = null;
                System.out.println("Danh mục đã được xóa.");
                return;
            }
        }
        System.out.println("Không tìm thấy ID để xóa.");
    }
}
