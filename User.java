import java.util.ArrayList;
import java.util.List;

public class User {
    private String email;
    private String password;
    private int ticketCount;
    private List<String> bookings;

    public User(String email, String password, int ticketCount) {
        this.email = email;
        this.password = password;
        this.ticketCount = ticketCount;
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
