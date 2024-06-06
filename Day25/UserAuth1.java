package com.javasql;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserAuth {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            createTable(connection);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter User ID:");
            String userID = scanner.nextLine();
            System.out.println("Enter Password:");
            String password = scanner.nextLine();

            insertUser(connection, userID, password);

            System.out.println("Enter User ID for login:");
            String loginUserID = scanner.nextLine();
            System.out.println("Enter Password for login:");
            String loginPassword = scanner.nextLine();

            if (validateUser(connection, loginUserID, loginPassword)) {
                System.out.println("Access granted");
            } else {
                System.out.println("Access denied");
            }

            scanner.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void createTable(Connection connection) {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS User ("
                + "UserID VARCHAR(50) NOT NULL PRIMARY KEY, "
                + "PasswordHash VARCHAR(64) NOT NULL)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
            preparedStatement.execute();
            System.out.println("Table 'User' created or already exists.");
        } catch (SQLException e) {
            System.err.println("Error creating table: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void insertUser(Connection connection, String userID, String password) {
        String hashedPassword = hashPassword(password);
        String insertSQL = "INSERT INTO User (UserID, PasswordHash) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();
            System.out.println("User inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static boolean validateUser(Connection connection, String userID, String password) {
        String hashedPassword = hashPassword(password);
        String selectSQL = "SELECT * FROM User WHERE UserID = ? AND PasswordHash = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {
            preparedStatement.setString(1, userID);
            preparedStatement.setString(2, hashedPassword);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        } catch (SQLException e) {
            System.err.println("Error validating user: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    private static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
