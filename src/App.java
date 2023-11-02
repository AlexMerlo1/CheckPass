import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class App {
    public static Boolean CheckPass(String password) {
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        List<String> required_special = new ArrayList<>();

        // Add special characters to the requirements list
        String specialCharacters = "~!@#$%^&*()-=+_";
        for (char c : specialCharacters.toCharArray()) {
            required_special.add(String.valueOf(c));
        }

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } 
            else if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            } 
            else if (Character.isDigit(c)) {
                hasNumber = true;
            } 
            else if (required_special.contains(String.valueOf(c))) {
                hasSpecialChar = true;
            }
        }
        if (!hasUpperCase) {
            System.out.println("Your password is missing an uppercase letter.");
        }
        if (!hasLowerCase) {
            System.out.println("Your password is missing a lowercase letter.");
        }
        if (!hasNumber) {
            System.out.println("Your password is missing a number (0-9).");
        }
        if (!hasSpecialChar) {
            System.out.println("Your password is missing a special character.");
        }

        return hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar;
    }


    
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to CheckPass where your password will be checked.");
        System.out.println("Password must contain atleast 1 upper and lower case letter, one number 0-9 and a special character");
        System.out.println("Please enter a password: ");

        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        

        Boolean running = true;
        while (running) {
            if (CheckPass(password)) {
                System.out.println("Your password meets all the requirements");
                running = false;
            }
            else {
                System.out.println("Please enter a new password: ");
                password = scanner.nextLine();
            }
        }
        scanner.close();
    }
}
