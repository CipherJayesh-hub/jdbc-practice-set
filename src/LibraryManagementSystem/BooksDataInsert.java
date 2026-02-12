package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class BooksDataInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        //create db object
        DBConnection db = new DBConnection();
        // query
        String sql = "INSERT INTO books(book_id, title,author,category,quantity,available) VALUES (108, 'Deep Work', 'Cal Newport', 'Productivity', 3, 3)";
        try{
            // create database connection
            connection = db.getConnection();
            statement = connection.createStatement();
            int RowAffected = statement.executeUpdate(sql);
            if(RowAffected==0)
                System.out.println("Not inserted");
            else
                System.out.println("Inserted");


        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
        try{
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());;
        }
    }
}

/*
there waa a data to be inserted in books table

(101, 'Clean Code', 'Robert C. Martin', 'Programming', 5, 5)
(102, 'Effective Java', 'Joshua Bloch', 'Programming', 4, 4)
(103, 'Java Complete Reference', 'Herbert Schildt', 'Programming', 6, 6)
(104, 'Atomic Habits', 'James Clear', 'Self Help', 3, 3)
(105, 'Rich Dad Poor Dad', 'Robert Kiyosaki', 'Finance', 2, 2)
(106, 'The Alchemist', 'Paulo Coelho', 'Fiction', 5, 5)
(107, 'Think and Grow Rich', 'Napoleon Hill', 'Motivation', 4, 4)
(108, 'Deep Work', 'Cal Newport', 'Productivity', 3, 3)

 */
