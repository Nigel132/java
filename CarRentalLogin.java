import java.util.Scanner;

public class CarRentalLogin {
    public static void main(String[] args) {
        // Predefined correct credentials
        final String correctUsername = "admin";
        final String correctPassword = "pass123";

        Scanner scanner = new Scanner(System.in);
        int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();

            String password = "";

            // Try to mask password input if possible
            java.io.Console console = System.console();
            if (console != null) {
                // Use Console for password masking (works in terminal)
                char[] passwordChars = console.readPassword("Enter password: ");
                password = new String(passwordChars);
            } else {
                // Fallback for IDEs that don't support Console
                System.out.print("Enter password: ");
                password = scanner.nextLine();
                // Password masking is not possible in most IDEs
            }

            // Check credentials
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful! Welcome to the Car Rental System.");
                break;
            } else {
                attempts++;
                System.out.println("Incorrect username or password. Attempt " + attempts + " of 3.");
                if (attempts == 3) {
                    System.out.println("Maximum login attempts reached. Access denied.");
                }
            }
        }

        scanner.close();
    }
}