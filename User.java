import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private List<String> bookings;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.bookings = new ArrayList<>();
    }
}
