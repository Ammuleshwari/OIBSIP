import java.util.Random;
import java.util.Scanner;
public class game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int minRange = 1;
        int maxRange = 100;
        int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
        
        int attempts = 0;
        int maxAttempts = 5;
        System.out.println("Welcome to Guess the Number Game!");
        System.out.println("Guess a number between " + minRange + " and " + maxRange);
        
        while (attempts < maxAttempts) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            scanner.nextLine(); 
            attempts++;
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " correctly in " + attempts + " attempts!");
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Try again! The number is higher.");
            } else {
                System.out.println("Try again! The number is lower.");
            }
        }        
        if (attempts >= maxAttempts) {
            System.out.println("Sorry, you've reached the maximum number of attempts. The number was: " + randomNumber);
        }    
        scanner.close();
    }
}
