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
