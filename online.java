import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String profileInfo;

    public User(String username, String password, String profileInfo) {
        this.username = username;
        this.password = password;
        this.profileInfo = profileInfo;
    }

    public String getUsername() {
        return username;
    }

    public boolean authenticate(String enteredPassword) {
        return password.equals(enteredPassword);
    }

    public void updateProfile(String newProfileInfo) {
        this.profileInfo = newProfileInfo;
        System.out.println("Profile updated successfully!");
    }
}

class ExamSystem {
    private Map<String, User> users;

    public ExamSystem() {
        users = new HashMap<>();
    }

    public void registerUser(String username, String password, String profileInfo) {
        users.put(username, new User(username, password, profileInfo));
        System.out.println("User registered successfully!");
    }

    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.authenticate(password)) {
            System.out.println("Login successful!");
            return user;
        } else {
            System.out.println("Invalid username or password.");
            return null;
        }
    }

    public void logout(User user) {
        System.out.println("Logged out successfully!");
    }
}

public class online {
    public static void main(String[] args) {
        ExamSystem examSystem = new ExamSystem();
        examSystem.registerUser("Ammuleshwari", "honey123", "Some profile info");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String usernameInput = scanner.nextLine();
        System.out.print("Enter password: ");
        String passwordInput = scanner.nextLine();

        User loggedInUser = examSystem.login(usernameInput, passwordInput);
        if (loggedInUser != null) {
            loggedInUser.updateProfile("Updated profile information");

            examSystem.logout(loggedInUser);
        }
        scanner.close();
    }
}
