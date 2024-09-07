// File: AccountService.java
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountService {

    // Create a new bank account
    public void createAccount(String name, String address, String accountType, double initialBalance) throws SQLException {
        String query = "INSERT INTO accounts (name, address, account_type, balance) VALUES (?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, accountType);
            stmt.setDouble(4, initialBalance);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account created successfully.");
            }
        }
    }

    // Deposit money into account
    public void deposit(int accountId, double amount) throws SQLException {
        String query = "UPDATE accounts SET balance = balance + ? WHERE account_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Deposit successful.");
            }
        }
    }

    // Withdraw money from account
    public void withdraw(int accountId, double amount) throws SQLException {
        String query = "UPDATE accounts SET balance = balance - ? WHERE account_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setDouble(1, amount);
            stmt.setInt(2, accountId);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Withdrawal successful.");
            }
        }
    }

    // View account balance
    public void viewBalance(int accountId) throws SQLException {
        String query = "SELECT balance FROM accounts WHERE account_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                System.out.println("Account Balance: " + rs.getDouble("balance"));
            } else {
                System.out.println("Account not found.");
            }
        }
    }

    // Update customer details
    public void updateAccount(int accountId, String newName, String newAddress) throws SQLException {
        String query = "UPDATE accounts SET name = ?, address = ? WHERE account_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setString(2, newAddress);
            stmt.setInt(3, accountId);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account details updated.");
            }
        }
    }

    // Delete account
    public void deleteAccount(int accountId) throws SQLException {
        String query = "DELETE FROM accounts WHERE account_id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, accountId);
            
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Account deleted successfully.");
            }
        }
    }
}
