import java.util.Scanner;
class User {
    private String userId;
    private int pin;

    public User(String userId, int pin) {
        this.userId = userId;
        this.pin = pin;
    }

    public String getUserId() {
        return userId;
    }

    public int getPin() {
        return pin;
    }
}
class ATM {
    private User currentUser;

    public void start() {
        User user = new User("Ammu789", 1234); 
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter User ID: ");
        String userIdInput = scanner.nextLine();
        System.out.print("Enter PIN: ");
        int pinInput = scanner.nextInt();
        scanner.nextLine(); 
        if (userIdInput.equals(user.getUserId()) && pinInput == user.getPin()) {
            currentUser = user;
            System.out.println("Welcome to the ATM!");
            showOptions();
        } else {
            System.out.println("Invalid credentials. Exiting...");
        }
    }

    private void showOptions() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nATM Options:");
            System.out.println("1. Transactions History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Transaction History");
                    break;
                case 2:
                    System.out.println("Withdraw");
                    break;
                case 3:
                    System.out.println("Deposit");
                    break;
                case 4:
                    System.out.println("Transfer");
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }
    }
}
public class atminterface {
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
