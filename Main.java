import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

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
            userMenu();
        }
    }

    public static void adminMenu() {
        int adminOption = 0;
        while (adminOption != 3) {
            System.out.println("\n=========================================");
            System.out.println("                 ADMIN MENU                ");
            System.out.println("=========================================");
            System.out.println("1. Add Event");
            System.out.println("2. Remove Event");
            System.out.println("3. Exit");
            System.out.println("=========================================");
            System.out.print("Enter your choice: ");
            adminOption = scanner.nextInt();

            switch(adminOption) {
                case 1:
                    System.out.println("...");
                    addEvent();
                    break;
                case 2:
                    System.out.println("...");
                    removeEvent();
                    break;
                case 3:
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
                    System.out.println("...");
                    events();
                    break;
                case 2:
                    System.out.println("...");
                    bookTickets();
                case 3:
                    System.out.println("...");
                    cancelTickets();
                    break;
                case 4:
                    System.out.println("...");
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
        System.out.println("UC");
    }
    public static void removeEvent() {
        System.out.println("UC");
    }
    public static void events() {
        System.out.println("UC");
    }
    public static void bookTickets() {
        System.out.println("UC");
    }
    public static void cancelTickets() {
        System.out.println("UC");
    }
    public static void viewBookings() {
        System.out.println("UC");
    }
}
