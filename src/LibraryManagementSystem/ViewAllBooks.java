package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewAllBooks {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBConnection db = new DBConnection();
        String sql = "SELECT * FROM books";
        try{
            connection = db.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("book_id") + " | " +
                                rs.getString("title") + " | " +
                                rs.getString("author") + " | " +
                                rs.getString("category") + " | " +
                                rs.getInt("quantity") + " | " +
                                rs.getInt("available")
                );
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            connection.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
**Description — ViewAllBooks**

This Java program retrieves and displays all records from the `books` table of a Library Management System database using JDBC. It establishes a connection through the `DBConnection` class, which manages database credentials and connection setup.

An SQL `SELECT` query is prepared to fetch all columns from the `books` table. The program executes the query using a `PreparedStatement` and stores the result in a `ResultSet`. It then iterates through each row using a `while` loop and prints book details such as book ID, title, author, category, quantity, and available copies in a formatted output.

Exception handling is included to catch and display any errors that occur during database operations. Finally, the program closes the `PreparedStatement` and database connection to release resources and ensure proper JDBC resource management.

 */
