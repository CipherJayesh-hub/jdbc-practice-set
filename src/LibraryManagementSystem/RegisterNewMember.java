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
