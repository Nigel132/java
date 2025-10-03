import java.io.Console;

public class LoginApp {
    public static void main(String[] args) {
        // Define correct logins
        String correctUsername = "admin";
        String correctPassword = "pass123";

        // Get the system console
        Console console = System.console();

        // Check if console is available
        if (console == null) {
            System.out.println("Console not available. Please run this program in a terminal.");
            return;
        }

        // Allow up to 3 login attempts
        for (int attempt = 1; attempt <= 3; attempt++) {
            System.out.println("\nAttempt " + attempt + " of 3");

            // Read username from console
            String username = console.readLine("Enter username: ").trim();
            // Read password securely from console
            char[] passwordChars = console.readPassword("Enter password: ");
            String password = new String(passwordChars);

            // Check if logins match
            if (username.equals(correctUsername) && password.equals(correctPassword)) {
                System.out.println("Login successful. Welcome, " + username + "!");
                return;
            } else {
                System.out.println("Incorrect username or password.");
                if (attempt < 3) {
                    System.out.println("Please try again.");
                }
            }
        }

        // Too many failed attempts
        System.out.println("\nMaximum login attempts exceeded. Access denied.");
    }
}