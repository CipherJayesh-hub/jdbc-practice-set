package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.Statement;

public class MemberDataInsert {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        //db object creation
        DBConnection db = new DBConnection();
        //query
         String sql = "INSERT INTO members(member_id,name,email,phone,join_date,status) VALUES (1, 'Jayesh Gehlot', 'jayesh@gmail.com', '9876543210', '2026-01-10', 'ACTIVE')";
//       String sql = "INSERT INTO members(member_id,name,email,phone,join_date,status) VALUES(2, 'Amit Sharma', 'amit@gmail.com', '9123456780', '2026-01-12', 'ACTIVE')";
//        String sql = "INSERT INTO members(member_id,name,email,phone,join_date,status) VALUES(3, 'Priya Verma', 'priya@gmail.com', '9988776655', '2026-01-15', 'ACTIVE')";
//        String sql = "INSERT INTO members(member_id,name,email,phone,join_date,status) VALUES(4, 'Rohit Singh', 'rohit@gmail.com', '9090909090', '2026-01-18', 'ACTIVE')";
//        String sql = "INSERT INTO members(member_id,name,email,phone,join_date,status) VALUES(5, 'Sneha Patel', 'sneha@gmail.com', '8888888888', '2026-01-20', 'INACTIVE')";
    try{
        // establish connection
        connection = db.getConnection();
        // establish statement
        statement = connection.createStatement();

        int RowsAffected = statement.executeUpdate(sql);
        if(RowsAffected==0)
            System.out.println("Not Inserted");
        else
            System.out.println("Inserted");


    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    try{
        statement.close();
        connection.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
    }
}
/*
the data was
(1, 'Jayesh Gehlot', 'jayesh@gmail.com', '9876543210', '2026-01-10', 'ACTIVE')
(2, 'Amit Sharma', 'amit@gmail.com', '9123456780', '2026-01-12', 'ACTIVE')
(3, 'Priya Verma', 'priya@gmail.com', '9988776655', '2026-01-15', 'ACTIVE')
(4, 'Rohit Singh', 'rohit@gmail.com', '9090909090', '2026-01-18', 'ACTIVE')
(5, 'Sneha Patel', 'sneha@gmail.com', '8888888888', '2026-01-20', 'INACTIVE')



**Short Description — MemberDataInsert**

This Java program inserts a member record into the `members` table using JDBC. It connects to the database through the `DBConnection` class, executes an SQL `INSERT` statement, verifies whether the insertion was successful based on affected rows, and then safely closes the statement and connection. Exception handling is included to manage runtime or SQL errors.

 */