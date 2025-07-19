import entity.User;

import java.time.LocalDate;

public class Task {
    private int id;
    private String title;
    private User assignedTo;
    private LocalDate dueDate;
    private boolean completed;

    // Constructor
    public Task(int id, String title, User assignedTo, LocalDate dueDate, boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.completed = completed;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    // Hiển thị thông tin
    public String toDisplayString() {
        return String.format("ID: %d | Tiêu đề: %s | Người nhận: %s | Hạn: %s | Hoàn thành: %s",
                id, title, assignedTo.getName(), dueDate, completed ? "True" : "False");
    }
}