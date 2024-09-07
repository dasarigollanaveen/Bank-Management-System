// File: Main.java
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AccountService accountService = new AccountService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Balance");
            System.out.println("5. Update Account");
            System.out.println("6. Delete Account");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            try {
                switch (choice) {
                    case 1:
                        // Create account
                        System.out.print("Enter name: ");
                        scanner.nextLine();  // Consume newline
                        String name = scanner.nextLine();
                        System.out.print("Enter address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter account type (Savings/Checking): ");
                        String accountType = scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double balance = scanner.nextDouble();
                        accountService.createAccount(name, address, accountType, balance);
                        break;

                    case 2:
                        // Deposit
                        System.out.print("Enter account ID: ");
                        int accountId = scanner.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        accountService.deposit(accountId, depositAmount);
                        break;

                    case 3:
                        // Withdraw
                        System.out.print("Enter account ID: ");
                        accountId = scanner.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        accountService.withdraw(accountId, withdrawAmount);
                        break;

                    case 4:
                        // View Balance
                        System.out.print("Enter account ID: ");
                        accountId = scanner.nextInt();
                        accountService.viewBalance(accountId);
                        break;

                    case 5:
                        // Update Account
                        System.out.print("Enter account ID: ");
                        accountId = scanner.nextInt();
                        System.out.print("Enter new name: ");
                        scanner.nextLine();  // Consume newline
                        String newName = scanner.nextLine();
                        System.out.print("Enter new address: ");
                        String newAddress = scanner.nextLine();
                        accountService.updateAccount(accountId, newName, newAddress);
                        break;

                    case 6:
                        // Delete Account
                        System.out.print("Enter account ID: ");
                        accountId = scanner.nextInt();
                        accountService.deleteAccount(accountId);
                        break;

                    case 7:
                        // Exit
                        System.out.println("Exiting the system. Thank you!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
