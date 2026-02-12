package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterNewMember {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBConnection db = new DBConnection();
        String sql = "INSERT INTO members(member_id,name,email, phone,join_date) VALUES (?,?,?,?,?)";
        try{
            connection = db.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            Scanner sc = new Scanner(System.in);
            System.out.println("enter data:---");
            System.out.print("member_id: ");
            Integer member_id = sc.nextInt();
            sc.nextLine(); // clear buffer
            System.out.print("name: ");
            String name = sc.nextLine();
            System.out.print("email: ");
            String email = sc.nextLine();
            System.out.print("phone: ");
            String phone = sc.nextLine();
            System.out.print("date: ");
            String date = sc.nextLine();

            preparedStatement.setInt(1,member_id);
            preparedStatement.setString(2,name);
            preparedStatement.setString(3,email);
            preparedStatement.setString(4,phone);
            preparedStatement.setString(5,date);

            int RowAffected = preparedStatement.executeUpdate();
            if(RowAffected==0)
                System.out.println("Not Inserted");
            else
                System.out.println("Member Data Inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            preparedStatement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

/*
**Description — RegisterNewMember**

This Java program registers a new member in the `members` table of a Library Management System database using JDBC and a `PreparedStatement`. It connects to the database through the `DBConnection` class, which handles connection setup and credentials.

The program defines an SQL `INSERT` query with parameter placeholders and then prompts the user to enter member details such as member ID, name, email, phone number, and join date using a `Scanner`. Each input value is assigned to the query parameters using appropriate setter methods (`setInt`, `setString`), ensuring safe and efficient execution while preventing SQL injection.

After setting all values, the query is executed using `executeUpdate()`. The returned row count determines whether the insertion was successful, and an appropriate message is displayed to the user. Exception handling is implemented to catch and print any runtime or SQL errors. Finally, the program closes both the `PreparedStatement` and database connection to properly release resources and maintain good JDBC practices.

 */