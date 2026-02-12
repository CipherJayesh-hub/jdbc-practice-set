package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddNewBook {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        //create db object
        DBConnection db = new DBConnection();
        //execute query
        String sql = "INSERT INTO books(book_id,title,author,category,quantity,available) VALUES (?,?,?,?,?,?)";
        try{
            connection = db.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Book Id: ");
            Integer book_id = sc.nextInt();
            sc.nextLine(); // clear buffer

            System.out.print("Title: ");
            String title = sc.nextLine();

            System.out.print("Author: ");
            String author = sc.nextLine();

            System.out.print("Category: ");
            String category = sc.nextLine();

            System.out.print("Quantity: ");
            Integer quantity = sc.nextInt();

// Available automatically equals quantity
            Integer available = quantity;


            // value insert in query
            preparedStatement.setInt(1,book_id);
            preparedStatement.setString(2,title);
            preparedStatement.setString(3,author);
            preparedStatement.setString(4,category);
            preparedStatement.setInt(5,quantity);
            preparedStatement.setInt(6,available);

            int RowAffected = preparedStatement.executeUpdate();
            if(RowAffected==0)
                System.out.println("Not Inserted");
            else
                System.out.println("Book Added Successfully");

        } catch (Exception e) {
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
**Description — AddNewBook**

This Java program allows a user to add a new book record into the `books` table of a Library Management System database using JDBC and a `PreparedStatement`. It first establishes a database connection through the `DBConnection` class, which manages connection credentials and setup.

The program defines an SQL `INSERT` query with placeholders (`?`) for values. It then prompts the user to enter book details such as book ID, title, author, category, and quantity using a `Scanner`. The available stock is automatically set equal to the entered quantity, ensuring that newly added books start with full availability.

Each user input value is safely assigned to the query using setter methods like `setInt()` and `setString()`, which helps prevent SQL injection and improves performance. The query is executed using `executeUpdate()`, and the program checks the number of affected rows to determine whether the insertion was successful.

If the operation succeeds, a success message is displayed; otherwise, it shows that insertion failed. Exception handling is included to manage runtime or database errors, and finally, the program closes both the `PreparedStatement` and database connection to properly release resources.

 */
