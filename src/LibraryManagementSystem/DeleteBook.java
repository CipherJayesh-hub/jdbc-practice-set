package LibraryManagementSystem;

import com.mysql.cj.result.Row;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteBook {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DBConnection db = new DBConnection();
        String sql = "DELETE FROM books WHERE book_id =?";
        try{
            connection = db.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            // enter data
            preparedStatement.setInt(1,111);
            int RowAffected = preparedStatement.executeUpdate();
            if (RowAffected==0)
                System.out.println("not inserted");
            else
                System.out.println("Inserted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try{
            connection.close();
            preparedStatement.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
