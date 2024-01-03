import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }
}

class ReservationSystem {
    public boolean makeReservation(String trainNumber, String classType, String dateOfJourney, String from, String to) {
        return true; 
    }
    public void cancelReservation(String pnrNumber) {
       
    }
}

public class reservation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User authorizedUser = new User("Ammuleshwari", "honey123");    
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        if (authorizedUser.authenticate(passwordInput)) {
            System.out.println("Login successful!");
            ReservationSystem reservationSystem = new ReservationSystem();
            System.out.println("Enter details for reservation:");
            boolean reservationSuccess = reservationSystem.makeReservation("123", "First Class", "2023-12-25", "City A", "City B");
            if (reservationSuccess) {
                System.out.println("Reservation successful!");
            } else {
                System.out.println("Reservation failed. Please try again.");
            }
            System.out.print("Enter PNR number for cancellation: ");
            String pnrNumber = scanner.nextLine();
            reservationSystem.cancelReservation(pnrNumber);
            System.out.println("Cancellation request processed.");

        } else {
            System.out.println("Invalid username or password. Access denied.");
        }
        scanner.close();
    }
}
