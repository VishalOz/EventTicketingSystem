import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String date;
    private String venue;
    private String time;

    public static List<Event> eventsList = new ArrayList<>();

    public Event(String name, String date, String venue, String time) {
        this.name = name;
        this.date = date;
        this.venue = venue;
        this.time = time;
    }
    @Override
    public String toString() {
        return "Event: "+name+ " |  Date: "+date+ " |  Venue: "+venue+ " |  Time: "+time;
    }

    public String getName() {
        return name;
    }
    public String getDate() {
        return date;
    }
    public String getVenue() {
        return venue;
    }
    public String getTime() {
        return time;
    }
}
