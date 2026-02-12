package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.Statement;

public class issued_booksDataInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        DBConnection db = new DBConnection();
        String sql = "INSERT INTO issued_books(issue_id, book_id, member_id, issue_date, return_date, status) VALUES (5001, 103, 1, '2026-02-01', NULL, 'ISSUED')";
//        String sql = "INSERT INTO issued_books(issue_id,book_id,member_id,issue_date,return_date,status) VALUES (5002, 104, 2, '2026-02-02', NULL, 'ISSUED')";
//        String sql = "INSERT INTO issued_books(issue_id,book_id,member_id,issue_date,return_date,status) VALUES (5003, 106, 3, '2026-01-25', '2026-02-05', 'RETURNED')";
//        String sql = "INSERT INTO issued_books(issue_id,book_id,member_id,issue_date,return_date,status) VALUES (5004, 107, 4, '2026-02-03', NULL, 'ISSUED')";

        try{
            connection = db.getConnection();
            statement = connection.createStatement();
            int RowAffected = statement.executeUpdate(sql);
            if (RowAffected==0)
                System.out.println("not Inserted");
            else
                System.out.println("Inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            connection.close();
            statement.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


/*
**Description — issued_booksDataInsert**

This Java program inserts a book issue record into the `issued_books` table of a Library Management System database using JDBC. It creates a connection through the `DBConnection` class, which centralizes database credentials and connection logic. An SQL `INSERT` statement is defined to store issue details such as issue ID, book ID, member ID, issue date, return date, and current status.

After establishing the database connection, the program creates a `Statement` object and executes the query using `executeUpdate()`. The returned value indicates how many rows were affected. If the value is greater than zero, the program prints a success message; otherwise, it indicates that insertion failed.

Exception handling is implemented to catch and display any runtime or SQL errors that occur during execution. Finally, both the statement and connection are closed properly to release database resources and prevent memory leaks.

 */