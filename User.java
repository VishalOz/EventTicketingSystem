import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private List<Event> bookings;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.bookings = new ArrayList<>();
    }

    public void bookEvent(Event event) {
        bookings.add(event);
    }

    public void cancelBooking(int index) {
        if (index >= 0 && index < bookings.size()) {
            bookings.remove(index);
        }
    }
    public List<Event> getBookings() {
        return bookings;
    }
}
