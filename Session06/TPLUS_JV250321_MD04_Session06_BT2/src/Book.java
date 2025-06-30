public class Book {
    private String title;
    private String author;
    private double price;

    // Setter cho title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter cho title
    public String getTitle() {
        return title;
    }

    // Setter cho author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter cho author
    public String getAuthor() {
        return author;
    }

    // Setter cho price (có kiểm tra hợp lệ)
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Giá không được âm");
        }
    }

    // Getter cho price
    public double getPrice() {
        return price;
    }
}

