import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static User currentUser = null;

    public static void main (String[] args){

        final String adminEmail = "adminhtomn@gmail.com";
        final String adminPassword = "admin123";

        System.out.println("|------------ LOGIN -------------|");
        System.out.print("EMAIL: ");
        String email = scanner.nextLine();
        System.out.print("PASSWORD: ");
        String password = scanner.nextLine();

        if (email.equals(adminEmail) && password.equals(adminPassword)) {
            adminMenu();
        }else {
            currentUser = new User(email, password);
            userMenu();
        }
    }

    public static void adminMenu() {
        int adminOption = 0;
        while (adminOption != 4) {
            System.out.println("\n=========================================");
            System.out.println("                 ADMIN MENU                ");
            System.out.println("=========================================");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. View All Events");
            System.out.println("4. Exit");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");
            adminOption = scanner.nextInt();

            switch(adminOption) {
                case 1:
                    addEvent();
                    break;
                case 2:
                    removeEvent();
                    break;
                case 3:
                    events();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input..");
            }
        }

    }

    public static void userMenu() {
        int userOption = 0;
        while (userOption != 5) {
            System.out.println("\n=========================================");
            System.out.println("                 USER MENU               ");
            System.out.println("=========================================");
            System.out.println("1. View All Events");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. View My Bookings");
            System.out.println("5. Exit");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");
            userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    events();
                    break;
                case 2:
                    bookTickets();
                    break;
                case 3:
                    cancelTickets();
                    break;
                case 4:
                    viewBookings();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input...");
            }
        }
    }

    public static void addEvent() {
        scanner.nextLine();
        System.out.print("Event name: ");
        String name = scanner.nextLine();
        System.out.print("Date: ");
        String date = scanner.nextLine();
        System.out.print("Venue: ");
        String venue = scanner.nextLine();
        System.out.print("Time: ");
        String time = scanner.nextLine();

        Event.eventsList.add(new Event(name, date, venue, time ));
        System.out.println("Event added successfully!");
    }
    public static void removeEvent() {
        if (Event.eventsList.isEmpty()) {
            System.out.println("No events to remove.");
            return;
        }
        events();
        System.out.println("Enter the number of event to remove: ");
        int index = scanner.nextInt();

        if (index > 0 && index <= Event.eventsList.size()) {
            Event removedEvent = Event.eventsList.remove(index-1);
            System.out.println("Event: "+removedEvent.getName() + " removed successfully.");
        }else {
            System.out.println("Invalid event number.");
        }
    }

    public static void events() {
        if (Event.eventsList.isEmpty()) {
            System.out.println("No Events Available.");
        }else {
            for (int i = 0; i < Event.eventsList.size(); i++) {
                System.out.println((i + 1) + ". "+Event.eventsList.get(i));
            }
        }
    }

    public static void bookTickets() {
        if (Event.eventsList.isEmpty()) {
            System.out.println("No Events Available");
            return;
        }
        events();
        System.out.println("Enter the number of the Event: ");
        int index = scanner.nextInt();

        if (index > 0 && index <= Event.eventsList.size()) {
            Event selectedEvent = Event.eventsList.get(index-1);
            currentUser.bookEvent(selectedEvent);
            System.out.println("Ticket booked for: "+selectedEvent.getName());
        }else {
            System.out.println("Invalid index number");
        }
    }

    public static void cancelTickets() {
        List<Event> bookings = currentUser.getBookings();
        if (bookings.isEmpty()) {
            System.out.println("No bookings to cancel");
            return;
        }
        viewBookings();
        System.out.println("Enter the number of the booking to cancel: ");
        int index = scanner.nextInt();

        if (index > 0 && index <= bookings.size()) {
            Event canceled = bookings.get(index - 1);
            currentUser.cancelBooking(index-1);
            System.out.println("Canceled booking for: " + canceled.getName());
        } else {
            System.out.println("Invalid booking number.");
        }

    }
    public static void viewBookings() {
        List<Event> bookings = currentUser.getBookings();

        if (bookings.isEmpty()) {
            System.out.println("You have no bookings.");
        } else {
            System.out.println("Your Bookings:");
            for (int i = 0; i < bookings.size(); i++) {
                System.out.println((i + 1) + ". " + bookings.get(i));
            }
        }
    }
}
