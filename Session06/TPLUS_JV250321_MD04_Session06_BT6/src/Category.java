public class Category {
    public String id;
    public String name;
    public String description;

    public Category(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category: " +
               "ID: " + id +
               ", Tên: " + name +
               ", Mô tả: " + description
               ;
    }
}

