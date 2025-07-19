package entity;

import java.util.Optional;

public class User {
    private int id;
    private String name;
    private Optional<String> email;

    // Constructor đầy đủ
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = Optional.ofNullable(email);
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(Optional<String> email) {
        this.email = email;
    }

    // Phương thức hiển thị
    public String toDisplayString() {
        return String.format("Tên: %s | Email: %s", id, email.orElse("Không có"));
    }
}