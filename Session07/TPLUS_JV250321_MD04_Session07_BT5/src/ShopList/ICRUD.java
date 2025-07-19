package ShopList;

public interface ICRUD {
    Category[] findAll();
    public void addCategory(Category category);
    public void updateCategory(Category category);
    public void deleteById(int id);
}
