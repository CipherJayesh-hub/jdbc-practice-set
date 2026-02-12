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
