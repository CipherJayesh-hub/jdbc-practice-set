package LibraryManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class UpdateBookQuantity {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        DBConnection db = new DBConnection();
        String sql = "UPDATE books SET quantity=?, available=? WHERE book_id=?";

        try{
            connection = db.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // enter data
            preparedStatement.setInt(1,10);
            preparedStatement.setInt(2,8);
            preparedStatement.setInt(3,111);

            int RowAffeted = preparedStatement.executeUpdate();
            if (RowAffeted==0)
                System.out.println("Not Inserted ");
            else
                System.out.println("Inserted ");




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
