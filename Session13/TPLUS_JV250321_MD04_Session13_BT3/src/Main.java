import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<User> users = Arrays.asList(
                new User("alice", "alice@example.com"),
                new User("bob", "bob@example.com"),
                new User("charlie", "charlie@example.com")
        );

        // Tìm kiếm người dùng theo username
        Optional<User> userOptional = findUserByUsername(users,"bob");

        // Sử dụng các phương thức của Optional
        if(userOptional.isPresent()) {
            System.out.println("User found: " + userOptional.get());
        } else  {
            System.out.println("User not found");
        }

        // Sử dụng orElse để cung cấp giá trị mặc định
        User defaultUser = userOptional.orElse(new User("default", "default@example.com"));
        System.out.println("Người dùng (mặc định nếu không tìm thấy): " + defaultUser);

        // 3. ifPresent – in email nếu tìm thấy
        userOptional.ifPresent(u ->
                System.out.println("Email của người dùng: " + u.getEmail())
        );
    }
    public static Optional<User> findUserByUsername(List<User> users, String username) {
        return users.stream()
                .filter(u -> u.getName().equalsIgnoreCase(username))
                .findFirst();
    }
}